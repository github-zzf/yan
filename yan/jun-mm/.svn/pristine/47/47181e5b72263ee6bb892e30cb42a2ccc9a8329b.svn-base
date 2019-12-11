package com.junkj.module.sys.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.codec.Md5Utils;
import com.junkj.common.config.Global;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.UserUtils;
import com.junkj.module.sys.dao.SysUserDao;
import com.junkj.module.sys.entity.SysUser;

/**
 * 操作日志biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-25
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysUserBiz extends CrudBiz<SysUserDao, SysUser> {

	/**
	 * 分页数据
	 */
	public Page<SysUser> findPage(SysUser sysUser) {
		return super.findPage(sysUser);
	}

	/**
	 * 通过username获取用户对象
	 */
	public SysUser getByUsername(String username) {
		SysUser user = new SysUser();
		user.setUsername(username);
		user.disableComId();
		return dao.getByEntity(user);
	}
	
	/**
	 * 通过name获取用户对象
	 */
	public SysUser getByName(String name) {
		SysUser user = new SysUser();
		user.setName(name);
		return dao.getByEntity(user);
	}
	
	/**
	 * 用户状态设置
	 */
	@Transactional(readOnly = false)
	public void updateStatus(SysUser user) {
		super.updateStatus(user);
		UserUtils.clearCache(user);
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false)
	public void delete(SysUser user) {
		UserUtils.clearCache(user);
		super.delete(user);
	}

	/**
	 * 保存用户
	 */
	@Transactional(readOnly = false)
	public void save(SysUser user) {
		if (user.getIsNewT()) {
			if(StrUtils.notBlank(user.getPassword())){
				user.setPassword(Md5Utils.md5Salt(user.getPassword(), user.getUsername()));
			}else{
				user.setPassword(Md5Utils.md5Salt(Global.getConfig("user.resetPass"), user.getUsername()));
			}
			user.setId(user.getUsername() + "_" + StrUtils.getRandomStr(4));
			user.preInsert();
			super.insert(user);
		} else {
			if(StrUtils.notBlank(user.getPassword())){
				user.setPassword(Md5Utils.md5Salt(user.getPassword(), user.getUsername()));
			}
			user.preUpdate();
			super.update(user);
		}
		UserUtils.clearCache(user);
	}

	/**
	 * 修改密码
	 */
	@Transactional(readOnly = false)
	public void updatePassword(String id, String password) {
		SysUser old = UserUtils.get(id);
		SysUser user = new SysUser();
		user.setId(id);
		user.setPassword(Md5Utils.md5Salt(password, old.getUsername()));
		super.update(user);
		UserUtils.clearCache(user);
	}

	/**
	 * 查询用户
	 */
	public SysUser getByComUser(String comId, String username, String userType) {
		SysUser user = new SysUser();
		user.setComId(comId);
		user.setUsername(username);
		user.setUserType(userType);
		return dao.getByEntity(user);
	}

}
