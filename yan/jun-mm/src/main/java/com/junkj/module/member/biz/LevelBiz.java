package com.junkj.module.member.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.member.dao.LevelDao;
import com.junkj.module.member.entity.Level;

/**
 * 会员级别biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class LevelBiz extends CrudBiz<LevelDao, Level> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<Level> findPage(Level level) {
		return super.findPage(level);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Level> findList(Level level) {
		return super.findList(level);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Level level) {
		super.save(level);
	}

}
