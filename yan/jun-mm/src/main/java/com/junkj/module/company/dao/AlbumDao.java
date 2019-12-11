package com.junkj.module.company.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.Album;

/**
 * 相册dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月19日
 * @version: 1.0.0
 */
@MyBatisDao
public interface AlbumDao extends CrudDao<Album> {

}
