package com.junkj.module.member.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.member.dao.CardUserDao;
import com.junkj.module.member.entity.CardUser;

/**
 * 会员卡记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class CardUserBiz extends CrudBiz<CardUserDao, CardUser> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<CardUser> findPage(CardUser cardUser) {
		return super.findPage(cardUser);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<CardUser> findList(CardUser cardUser) {
		return super.findList(cardUser);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CardUser cardUser) {
		super.save(cardUser);
	}
}
