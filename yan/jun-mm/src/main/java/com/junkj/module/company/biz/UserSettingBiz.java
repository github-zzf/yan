package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.UserSettingDao;
import com.junkj.module.company.entity.UserSetting;

/**
 * 企业用户设置biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class UserSettingBiz extends CrudBiz<UserSettingDao, UserSetting> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<UserSetting> findPage(UserSetting userSetting) {
		return super.findPage(userSetting);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<UserSetting> findList(UserSetting userSetting) {
		return super.findList(userSetting);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(UserSetting userSetting) {
		super.save(userSetting);
	}
	
}
