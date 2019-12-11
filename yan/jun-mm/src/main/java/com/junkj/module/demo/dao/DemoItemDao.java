package com.junkj.module.demo.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.demo.entity.DemoItem;

/**
 * 子表示例dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月07日
 * @version: 1.0.0
 */
@MyBatisDao
public interface DemoItemDao extends CrudDao<DemoItem> {

}
