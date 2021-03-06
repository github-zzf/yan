package com.junkj.module.weixin.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.weixin.dao.WxUserDao;
import com.junkj.module.weixin.entity.WxUser;

/**
 * 微信用户biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月22日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class WxUserBiz extends CrudBiz<WxUserDao, WxUser> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<WxUser> findPage(WxUser wxUser) {
		return super.findPage(wxUser);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<WxUser> findList(WxUser wxUser) {
		return super.findList(wxUser);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(WxUser wxUser) {
		super.save(wxUser);
	}

	/**
	 * 通过staffId查询会员
	 */
	public WxUser getByStaffId(String staffId) {
		return dao.getByStaffId(staffId);
	}

	/**
	 * 通过saleId查询会员
	 */
	public WxUser getBySaleId(String saleId) {
		return dao.getBySaleId(saleId);
	}
	/**
	 * 绑定微信
	 */
	public void updateMemberId(String comId, String memberId, String delMemberId) {
		dao.updateMemberId(comId, memberId, delMemberId);
		
	}

}
