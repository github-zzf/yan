package com.junkj.module.file.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.file.utils.FileUploadUtils;

@Table(name = "sys_file_upload", alias = "a", columns = {
		@Column(name = "id", attrName = "id", label = "编号", isPK = true),
		@Column(name = "file_id", attrName = "fileEntity.fileId", label = "文件编号"),
		@Column(name = "file_name", attrName = "fileName", label = "文件名称", queryType = QueryType.LIKE),
		@Column(name = "file_type", attrName = "fileType", label = "文件分类", comment = "文件分类（image、media、file）"),
		@Column(name = "biz_id", attrName = "bizId", label = "业务主键"),
		@Column(name = "biz_type", attrName = "bizType", label = "业务类型"),
		@Column(includeEntity = DataEntity.class) 
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = FileEntity.class, alias = "b", on = "b.file_id = a.file_id")
	}, orderBy = "a.id"
)
public class FileUpload extends DataEntity<FileUpload> {

	public static final String TYPE_FILE = "file";
	public static final String TYPE_IMAGE = "image";
	public static final String TYPE_MEDIA = "media";
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String fileType;
	private String bizId;
	private String bizType;
	private FileEntity fileEntity;

	public FileUpload() {
		super(null);
	}

	public FileUpload(String fileUploadId) {
		super(fileUploadId);
	}

	public FileUpload(FileEntity fileEntity) {
		super(null);
		this.fileEntity = fileEntity;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@NotBlank(message = "文件名称不能为空")
	@Length(min = 0, max = 500, message = "文件名称长度不能超过 500 个字符")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@NotBlank(message = "文件分类不能为空")
	@Length(min = 0, max = 20, message = "文件分类长度不能超过 20 个字符")
	public String getFileType() {
		return this.fileType;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	@Length(min = 0, max = 64, message = "业务主键长度不能超过 64 个字符")
	public String getBizId() {
		return this.bizId;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	@Length(min = 0, max = 64, message = "业务类型长度不能超过 64 个字符")
	public String getBizType() {
		return this.bizType;
	}

	public void setFileEntity(FileEntity fileEntity) {
		this.fileEntity = fileEntity;
	}

	@NotNull(message = "文件实体不能为空")
	public FileEntity getFileEntity() {
		if (this.fileEntity == null) {
			fileEntity = new FileEntity();
		}
		return this.fileEntity;
	}

	public String getFileUrl() {
		return getFileEntity().getFileUrl();
	}
}
