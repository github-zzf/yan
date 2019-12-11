package com.junkj.module.company.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.junkj.common.collect.ListUtils;
import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.file.entity.FileUpload;
import com.junkj.module.sys.entity.SysUser;

/**
 * 相册实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月19日
 * @version: 1.0.0
 */
@Table(name = "com_album", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "name", attrName = "name", queryType = QueryType.LIKE),
		@Column(name = "img", attrName = "img"),
		@Column(name = "clicks", attrName = "clicks"),
		@Column(includeEntity = DataEntity.class),
		@Column(includeEntity = BaseEntity.class) 
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "b", on = "b.id = a.update_id ", columns = {
			@Column(name = "name", attrName = "updateName", queryType = QueryType.LIKE) 
		})
	}, orderBy = "a.id DESC")
public class Album extends DataEntity<Album> {

	private static final long serialVersionUID = 1L;
	public static final String FILE_TYPE = "album_img";

	private String name; // 相册名称
	private String img; // 封面图片
	private Long clicks; // 浏览量
	private String remark; // 相册描述

	// 业务字段
	List<FileUpload> fileUpload = ListUtils.newArrayList();

	@NotEmpty(message = "相册名称不能为空")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getClicks() {
		return clicks;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<FileUpload> getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(List<FileUpload> fileUpload) {
		this.fileUpload = fileUpload;
	}

}