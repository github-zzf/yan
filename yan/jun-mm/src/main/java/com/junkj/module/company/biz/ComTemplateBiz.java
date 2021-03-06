package com.junkj.module.company.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.Template;
import com.junkj.module.company.dao.ComTemplateDao;
import com.junkj.module.company.entity.ComTemplate;

/**
 * 企业模板消息biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ComTemplateBiz extends CrudBiz<ComTemplateDao, ComTemplate> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<ComTemplate> findPage(ComTemplate comTemplate) {
		return super.findPage(comTemplate);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<ComTemplate> findList(ComTemplate comTemplate) {
		return super.findList(comTemplate);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(ComTemplate comTemplate) {
		super.save(comTemplate);
		ComUtils.removeTemplate(comTemplate.getComId(), comTemplate.getTplCode());
	}

	/**
	 * 通过code查询
	 */
	public List<Template> getByCode(String comId, String code) {
		ComTemplate where = new ComTemplate();
		where.setComId(comId);
		where.setTplCode(code);
		ComTemplate comTpl = getByEntity(where);
		ArrayList<Template> list = ListUtils.newArrayList();
		if (comTpl != null && StrUtils.notBlank(comTpl.getTplId())) {
			String [] arr = comTpl.getTplParams().split(",");
			Template tpl = null;
			for (String param : arr) {
				tpl = new Template();
				tpl.setId(comTpl.getTplId());
				tpl.setName(param);
				list.add(tpl);
			}
		}
		return list;
	}

}
