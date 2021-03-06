package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.config.Global;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.MemberUtils;
import com.junkj.common.utils.TplMsgUtils;
import com.junkj.module.company.dao.ActivityDao;
import com.junkj.module.company.entity.Activity;
import com.junkj.module.company.entity.ActivityEnroll;
import com.junkj.module.file.utils.FileUploadUtils;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.entity.Member;

/**
 * 活动biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class ActivityBiz extends CrudBiz<ActivityDao, Activity> {

	@Autowired
	private ActivityEnrollBiz activityEnrollBiz;
	@Autowired
	private MemberBiz memberBiz;
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<Activity> findPage(Activity activity) {
		return super.findPage(activity);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Activity> findList(Activity activity) {
		return super.findList(activity);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Activity activity) {
		if(!activity.getIsNewT()){
			// 查询等位人数
			ActivityEnroll enrollWhere = new ActivityEnroll();
			enrollWhere.setActivityId(activity.getId());
			enrollWhere.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
			List<ActivityEnroll> enrollList = activityEnrollBiz.findList(enrollWhere);
			// 查询报名人数
			ActivityEnroll newEnroll = new ActivityEnroll();
			newEnroll.setActivityId(activity.getId());
			newEnroll.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_0);
			List<ActivityEnroll> newEnrollList = activityEnrollBiz.findList(newEnroll);
			// 人数上限 大于 报名人数 等位人数大于0
			if(activity.getPeopleMax() > newEnrollList.size() && enrollList.size() > 0){
				ActivityEnroll updateActivityEnroll = new ActivityEnroll();
				Long waitNum = 1L;
				for (int i = 0; i < enrollList.size(); i++) {
					if (i <(activity.getPeopleMax() - newEnrollList.size())) {
						activityEnrollBiz.updateActivityEnroll(enrollList.get(i).getId());
						ActivityEnroll eActivityEnroll = enrollList.get(i);
						// 微信模板消息：会员报名通知
						Member member = memberBiz.get(eActivityEnroll.getMemberId());
						if (member != null && StrUtils.notBlank(member.getOpenId())) {
							String comId = ComUtils.getCurrentComId();
							new Thread() {
								public void run() {
									try {
										List<String> data = ListUtils.newArrayList();
										data.add("您有一条预约活动通知!");
										data.add(activity.getName() + "\\n开始时间:" + DateUtils.formatDateTime(activity.getStartTime())
												+ "\\n结束时间:" + DateUtils.formatDateTime(activity.getEndTime()));
										data.add(DateUtils.getDateTime());
										data.add("点击查看详情");
										String url = ComUtils.getComUrl(comId, "/mobile#/pages/activityList/activityList?type=my");
										TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_3, data);
									} catch (Exception e) {
										logger.error("预约通知失败", e);
									}
								}
							}.start();
						}
					} else {
						updateActivityEnroll = enrollList.get(i);
						updateActivityEnroll.setWaitNum(waitNum);
						waitNum++;
					}
					activityEnrollBiz.update(updateActivityEnroll);
				}
			}
		}
		setStatus(activity);
		activity.setContent(HtmlUtils.htmlUnescape(activity.getContent()));
		super.save(activity);
		// 保存上传图片
		String img = FileUploadUtils.saveFileUpload(activity.getId(), Activity.FILE_TYPE);
		if (StrUtils.notBlank(img)) {
			activity.setImg(img);
			super.update(activity);
		}
	}

	// 更新活动状态
	public void setStatus(Activity activity) {
		if (Activity.STATUS_4.equals(activity.getStatus())) {
			return;
		}
		if (DateUtils.after(DateUtils.getDate(), DateUtils.format(activity.getEndTime()), "yyyy-MM-dd")) {
			activity.setStatus(Activity.STATUS_3);
		} else if (DateUtils.after(DateUtils.getDate(), DateUtils.format(activity.getEnrollEnd()), "yyyy-MM-dd")) {
			activity.setStatus(Activity.STATUS_2);
		} else if (DateUtils.after(DateUtils.getDate(), DateUtils.format(activity.getEnrollStart()), "yyyy-MM-dd")) {
			activity.setStatus(Activity.STATUS_1);
		} else {
			activity.setStatus(Activity.STATUS_0);
		}
	}

	/**
	 * 清空会员卡
	 */
	@Transactional(readOnly = false)
	public void updateActivityCardIdNull(Activity activity) {
		dao.updateActivityCardIdNull(activity.getId());
	}

	/**
	 * 我的活动
	 */
	public Page<Activity> pageMyActity(Activity activity) {
		activity.setWhere(
				"a.status <> 9 and a.id in (select DISTINCT activity_id from com_activity_enroll where member_id="
						+ MemberUtils.getMemberId() + " and com_id = #{comId})");
		return super.findPage(activity);
	}

	/**
	 * 定时更新活动状态
	 */
	@Transactional(readOnly = false)
	public void updateAllStatus() {
		dao.updateAllStatus();
	}

}
