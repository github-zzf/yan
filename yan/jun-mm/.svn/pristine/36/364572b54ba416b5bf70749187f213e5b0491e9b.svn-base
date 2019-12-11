package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.FeedbackDao;
import com.junkj.module.company.entity.Feedback;

/**
 * 意见反馈biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月19日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class FeedbackBiz extends CrudBiz<FeedbackDao, Feedback> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<Feedback> findPage(Feedback feedback) {
		return super.findPage(feedback);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<Feedback> findList(Feedback feedback) {
		return super.findList(feedback);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Feedback feedback) {
		super.save(feedback);
	}
	
	/**
	 * 标记已读
	 */
	@Transactional(readOnly=false)
	public void updateFeedbackStatus(String ids) {
		for (String id : ids.split(",")) {
			Feedback feedback = new Feedback();
			feedback.setId(id);
			feedback.setStatus(Feedback.STATUS_1);
			super.update(feedback);
		}
	}
	
}
