package com.junkj.module.company.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.MobileSetting;

/**
 * 官网设置dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@MyBatisDao
public interface MobileSettingDao extends CrudDao<MobileSetting> {

}
