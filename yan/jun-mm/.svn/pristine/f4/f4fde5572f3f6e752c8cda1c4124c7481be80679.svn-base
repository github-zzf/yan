package com.junkj.module.sys.biz;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.utils.ConfigUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.sys.dao.SysConfigDao;
import com.junkj.module.sys.entity.SysConfig;

/**
 * 参数配置biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月12日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysConfigBiz extends CrudBiz<SysConfigDao, SysConfig> {

	@Autowired
	private SysConfigDao sysConfigDao;

	/**
	 * 分页数据
	 */
	@Override
	public Page<SysConfig> findPage(SysConfig sysConfig) {
		return super.findPage(sysConfig);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<SysConfig> findList(SysConfig sysConfig) {
		return super.findList(sysConfig);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(SysConfig sysConfig) {
		super.save(sysConfig);
		ConfigUtils.clearCache(sysConfig.getConfigKey());
	}

	/**
	 * 删除
	 */
	@Override
	@Transactional(readOnly = false)
	public void delete(SysConfig sysConfig) {
		super.delete(sysConfig);
		ConfigUtils.clearCache(sysConfig.getConfigKey());
	}

	/**
	 * 通过key查询,企业配置
	 */
	public String getValByKey(String string) {
		SysConfig where = new SysConfig();
		where.setConfigKey(string);
		where.setIsSys(SysConfig.IS_SYS_FALSE);
		return sysConfigDao.getValByKey(where);
	}

	/**
	 * 通过key查询,系统配置
	 */
	public String getSysValByKey(String string) {
		SysConfig where = new SysConfig();
		where.setConfigKey(string);
		where.setIsSys(SysConfig.IS_SYS_TRUE);
		where.disableComId();
		return sysConfigDao.getValByKey(where);
	}

}
