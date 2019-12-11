package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.CardsDao;
import com.junkj.module.company.entity.Cards;

/**
 * 储次卡biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class CardsBiz extends CrudBiz<CardsDao, Cards> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<Cards> findPage(Cards cards) {
		return super.findPage(cards);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Cards> findList(Cards cards) {
		return super.findList(cards);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Cards cards) {
		super.save(cards);
	}

}
