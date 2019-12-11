package com.junkj.module.company.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.module.company.dao.ComConfigDao;
import com.junkj.module.company.entity.ComConfig;

/**
 * 参数配置biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ComConfigBiz extends CrudBiz<ComConfigDao, ComConfig> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<ComConfig> findPage(ComConfig comConfig) {
		return super.findPage(comConfig);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<ComConfig> findList(ComConfig comConfig) {
		return dao.findList(comConfig);
	}
	/**
	 * 列表数据配置
	 */
	public List<ComConfig> findConfig(String configKey1,String configKey2,String configKey3) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comId", ComUtils.getCurrentComId());
		if(StrUtils.notBlank(configKey1)) {
			map.put("configKey1", configKey1);
		}
		if(StrUtils.notBlank(configKey2)) {
			map.put("configKey2", configKey2);
		}
		if(StrUtils.notBlank(configKey3)) {
			map.put("configKey3", configKey3);
		}
		return dao.findConfig(map);
	}
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ComConfig comConfig) {
		super.save(comConfig);
	}
	
	/**
	 * 获取企业配置
	 */
	@Transactional(readOnly=false)
	public String getByKey(String key){
		ComConfig where = new ComConfig();
		where.setConfigKey(key);
		ComConfig c = getByEntity(where);
		if(c==null){
			return null;
		}
		return c.getConfigValue();
	}
	
	/**
	 * 获取企业配置
	 */
	@Transactional(readOnly=false)
	public String getByKey(String comId, String key){
		ComConfig where = new ComConfig();
		where.setConfigKey(key);
		ComConfig c = getByEntity(where);
		if(c==null){
			return null;
		}
		return c.getConfigValue();
	}
	
}
