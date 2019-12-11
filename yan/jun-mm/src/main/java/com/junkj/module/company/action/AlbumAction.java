package com.junkj.module.company.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.company.biz.AlbumBiz;
import com.junkj.module.company.entity.Album;

/**
 * 相册action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月19日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/album")
public class AlbumAction extends BaseAction {

	@Autowired
	private AlbumBiz albumBiz;

	@RequiresPermissions("company:album:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/album";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:album:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Album> listPage(Album album) {
		Page<Album> page = albumBiz.findPage(album);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:album:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Album> findList(Album album) {
		List<Album> list = albumBiz.findList(album);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:album:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated Album album, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		albumBiz.save(album);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:album:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Album album) {
		albumBiz.delete(album);
		return sendOk("删除成功！");
	}

}