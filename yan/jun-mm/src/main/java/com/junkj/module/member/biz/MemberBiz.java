package com.junkj.module.member.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.company.biz.ComMemberBiz;
import com.junkj.module.company.entity.ComMember;
import com.junkj.module.excel.biz.ExcelTplBiz;
import com.junkj.module.member.dao.MemberDao;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.Points;
import com.junkj.module.shop.biz.GiftBiz;
import com.junkj.module.shop.entity.Gift;
import com.junkj.module.sys.dao.ComboDao;

/**
 * 会员biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class MemberBiz extends CrudBiz<MemberDao, Member> {

	@Autowired
	private PointsBiz pointsBiz;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private GiftBiz giftBiz;
	@Autowired
	private ComMemberBiz comMemberBiz;
	@Resource
	private ExcelTplBiz excelTplBiz;
	@Autowired
	private ComboDao comboDao;

	/**
	 * 分页数据
	 */
	@Override
	public Page<Member> findPage(Member member) {
		return super.findPage(member);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Member> findList(Member member) {
		return super.findList(member);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Member member) {
		boolean isNewT = member.getIsNewT();
		super.save(member);
		ComMember cm = new ComMember();
		cm.setMemberId(member.getId());
		cm.setLevelId(member.getLevelId());
		cm.setRemark(member.getRemark());
		if (isNewT) {
			// 保存企业关联
			cm.setPoints(0L);
			cm.setSource(ComMember.SOURCE_1);
			comMemberBiz.insert(cm);
		}else {
			comMemberBiz.update(cm);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(Member member) {
		ComMember cm = new ComMember();
		cm.setMemberId(member.getId());
		comMemberBiz.delete(cm);
	}

	/**
	 * 添加积分
	 */
	@Transactional(readOnly = false)
	public void updateAddPoints(Member member) {
		ComMember comMember = comMemberBiz.get(member.getId());
		comMember.setPoints(comMember.getPoints() + member.getNewPoints());
		comMemberBiz.update(comMember);
		Points points = new Points();
		points.setMemberId(member.getId());
		points.setBizType(Points.BIZTYPE_4);
		points.setType(Points.TYPE_1);
		points.setNum(member.getNewPoints());
		pointsBiz.save(points);
	}

	/**
	 * 积分兑换
	 */
	@Transactional(readOnly = false)
	public JsonVo updateReducePoints(String id, String giftId) {
		Gift gift = giftBiz.get(giftId);
		if (gift.getNum() < 1) {
			return JsonVo.sendError("库存不足!");
		}
		// 所需积分
		Long points = gift.getPoints();

		ComMember comMember = comMemberBiz.get(id);
		if (comMember.getPoints() < points) {
			return JsonVo.sendError("积分不足!");
		}
		// 更新会员积分余额
		comMember.setPoints(comMember.getPoints() - points);
		comMemberBiz.update(comMember);

		// 添加积分变更记录
		Points mp = new Points();
		mp.setMemberId(id);
		mp.setBizType(Points.BIZTYPE_5);
		mp.setType(Points.TYPE_2);
		mp.setNum(points);
		pointsBiz.save(mp);

		// 减少库存
		gift.setNum(gift.getNum() - 1);
		giftBiz.update(gift);
		return JsonVo.sendOk("兑换成功！");
	}

	/**
	 * 会员信息
	 * 
	 * @param memberId
	 * @return
	 */
	@Transactional(readOnly = false)
	public Map<String, Object> getMemberInfo(String memberId, String comId) {
		return memberDao.getMemberInfo(memberId, comId);
	}

	@Override
	public Member get(String memberId) {
		Member where = new Member();
		where.setComId(ComUtils.getCurrentComId());
		where.setId(memberId);
		where.setWhere("cm.com_id = #{comId}");
		return get(where);
	}

	/**
	 * 导入Excel
	 */
	@Transactional(readOnly = false)
	public Map<String, Object> saveMemberGetList(MultipartFile excelFile) {
		/** 提示信息 **/
		Map<String, Object> checkMsg = new HashMap<String, Object>();
		int totalCount = 0; // 总数量
		int successCount = 0; // 成功数量
		int errorCount = 0; // 失败数量
		List<Object> errors = new ArrayList<Object>();// 错误信息

		// 数据验证转换
		Map<String, Object> dataMap = excelTplBiz.checkTemplate(excelFile, "MEMBER", Member.class);
		if (dataMap != null) {
			totalCount = (int) dataMap.get("totalCount");
			int titleIndex = (int) dataMap.get("titleIndex");
			for (int i = titleIndex + 1; i <= totalCount + titleIndex + 2; i++) {
				Object obj = dataMap.get(String.valueOf(i));
				if (obj instanceof String) {
					errors.add(obj);
					errorCount++;
				} else if (obj instanceof Member) {
					Member vo = (Member) obj;
					Member member = new Member();
					BeanUtils.copyProperties(vo, member);
					
					String levelId = comboDao.findMemberLevelValue(ComUtils.getCurrentComId(), vo.getLevelTxt());
					if (levelId != null) {
						member.setLevelId(levelId);
					} else {
						errors.add("第"+i+"行：会员等级“" +vo.getLevelTxt()+ "”不存在");
						errorCount++;
						continue;
					}
					if(StrUtils.isBlank(vo.getPhone())){
						member.setIsNewT(false);
						member.preInsert();
						super.insert(member);
					}else{
						Member old = dao.getByPhone(vo.getPhone());
						if(old == null){
							member.setIsNewT(false);
							member.preInsert();
							super.insert(member);
						}else{
							member = old;
						}
					}
					ComMember cmw = new ComMember();
					cmw.setMemberId(member.getId());
					cmw = comMemberBiz.getByEntity(cmw);
					if(cmw != null){
						errors.add("第"+i+"行：会员“" +vo.getName()+ vo.getPhone()+ "”已存在");
						errorCount++;
						continue;
					}
					// 保存企业关联
					ComMember cm = new ComMember();
					cm.setMemberId(member.getId());
					cm.setLevelId(member.getLevelId());
					cm.setRemark(member.getRemark());
					cm.setPoints(0L);
					cm.setSource(ComMember.SOURCE_1);
					comMemberBiz.insert(cm);
					
					successCount++;
				}
			}
		}
		checkMsg.put("code", 1);
		checkMsg.put("totalCount", totalCount);
		checkMsg.put("successCount", successCount);
		checkMsg.put("errorCount", errorCount);
		checkMsg.put("errors", errors);
		return checkMsg;
	}

}
