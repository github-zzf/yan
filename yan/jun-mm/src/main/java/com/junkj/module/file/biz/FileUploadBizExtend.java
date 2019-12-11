package com.junkj.module.file.biz;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.junkj.common.io.FileUtils;
import com.junkj.module.file.entity.FileEntity;
import com.junkj.module.file.entity.FileUpload;
import com.junkj.module.file.entity.FileUploadParams;

public class FileUploadBizExtend {

	public void uploadFile(FileEntity fileEntity) {
	}

	public void saveUploadFile(FileUpload fileUpload) {
	}

	public String downFile(FileUpload fileUpload, HttpServletRequest request, HttpServletResponse response) {
		FileEntity a = fileUpload.getFileEntity();
		File file = new File(a.getFileRealPath());
		if (file.exists()) {
			FileUtils.downFile(file, request, response, fileUpload.getFileName());
			return null;
		}
		return "404";
	}

	public String getFileUrl(FileUpload fileUpload) {
		return fileUpload.getFileEntity().getFileUrl();
	}

	public boolean fileExists(FileEntity fileEntity) {
		String a = fileEntity.getFileRealPath();
		return (new File(a)).exists();
	}

	protected static Logger logger = LoggerFactory.getLogger(FileUploadBizExtend.class);

	public Map<String, Object> uploadFile(FileEntity fileEntity, FileUploadParams params) {
		return null;
	}
}
