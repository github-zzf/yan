package com.junkj.module.company.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.StaffNoticeSettingDao;
import com.junkj.module.company.entity.StaffNoticeSetting;

/**
 * 通知设置biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月12日
 */
@Service
@Transactional(readOnly = true)
public class StaffNoticeSettingBiz extends CrudBiz<StaffNoticeSettingDao, StaffNoticeSetting> {

	@Resource
	private StaffNoticeSettingDao staffNoticeSettingDao;

	/**
	 * 分页数据
	 */
	@Override
	public Page<StaffNoticeSetting> findPage(StaffNoticeSetting staffNoticeSetting) {
		return super.findPage(staffNoticeSetting);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<StaffNoticeSetting> findList(StaffNoticeSetting staffNoticeSetting) {
		return super.findList(staffNoticeSetting);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(StaffNoticeSetting staffNoticeSetting) {
		super.save(staffNoticeSetting);
	}

	/**
	 * 根据人员userId查询
	 */
	public StaffNoticeSetting getByUserId(String userId) {
		StaffNoticeSetting where = new StaffNoticeSetting();
		where.setUserId(userId);
		return super.getByEntity(where);
	}

}
