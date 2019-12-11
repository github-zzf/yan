package com.junkj.module.cms.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.module.cms.dao.ArticlesDao;
import com.junkj.module.cms.dao.ArttypeDao;
import com.junkj.module.cms.entity.Articles;
import com.junkj.module.cms.entity.Arttype;
import com.junkj.module.file.utils.FileUploadUtils;
import com.vdurmont.emoji.EmojiParser;

/**
 * 文章表biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月18日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ArticlesBiz extends CrudBiz<ArticlesDao, Articles> {

	@Autowired
	private ArticlesDao articlesDao;
	@Autowired
	private ArttypeDao arttypeDao;

	/**
	 * 分页数据
	 */
	@Override
	public Page<Articles> findPage(Articles articles) {
		return super.findPage(articles);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Articles> findList(Articles articles) {
		return super.findList(articles);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Articles articles) {
		articles.setBody(HtmlUtils.htmlUnescape(EmojiParser.parseToAliases(articles.getBody())));
		if (articles.getIsNewT()) {
			articles.setSendTime(new Date());
		}
		super.save(articles);
		// 保存上传图片
		String img = FileUploadUtils.saveFileUpload(articles.getId(), Articles.FILE_TYPE);
		if (StrUtils.notBlank(img)) {
			articles.setImg(img);
			super.update(articles);
		}
	}
	
}
