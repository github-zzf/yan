package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.CardsTypeDao;
import com.junkj.module.company.entity.CardsType;

/**
 * 会员卡分类biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月05日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class CardsTypeBiz extends CrudBiz<CardsTypeDao, CardsType> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<CardsType> findPage(CardsType cardsType) {
		return super.findPage(cardsType);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<CardsType> findList(CardsType cardsType) {
		return super.findList(cardsType);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CardsType cardsType) {
		super.save(cardsType);
	}
	
}
