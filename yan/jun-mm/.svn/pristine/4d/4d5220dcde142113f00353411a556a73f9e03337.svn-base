package com.junkj.module.file.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.biz.api.CrudBizApi;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.module.file.dao.FileEntityDao;
import com.junkj.module.file.entity.FileEntity;

@Transactional(readOnly = true)
public class FileEntityBiz extends CrudBiz<FileEntityDao, FileEntity> implements CrudBizApi<FileEntity> {

	@Autowired
	private FileUploadBizExtend fileUploadBizExtend;

	public FileEntity getByMd5(FileEntity fileEntity) {
		if (StrUtils.notBlank(fileEntity.getFileMd5())) {
			fileEntity.setPage(new Page<Object>(1, 1));
			Page<FileEntity> page = this.findPage(fileEntity);
			if (page.getList().size() > 0) {
				fileEntity = page.getList().get(0);
			}
		}
		fileEntity.setStatus("1");
		if (StrUtils.notBlank(fileEntity.getFileId()) && this.fileUploadBizExtend.fileExists(fileEntity)) {
			fileEntity.setStatus("0");
		}
		return fileEntity;
	}

}
