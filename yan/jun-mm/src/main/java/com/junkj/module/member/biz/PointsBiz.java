package com.junkj.module.member.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.member.dao.PointsDao;
import com.junkj.module.member.entity.Points;

/**
 * 积分记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class PointsBiz extends CrudBiz<PointsDao, Points> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<Points> findPage(Points points) {
		return super.findPage(points);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<Points> findList(Points points) {
		return super.findList(points);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Points points) {
		super.save(points);
	}
	
}
