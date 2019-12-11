package com.junkj.module.file.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.junkj.common.IdGen.IdGenerate;
import com.junkj.common.action.http.ServletUtils;
import com.junkj.common.config.Global;
import com.junkj.common.exception.SpringUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.PathUtils;
import com.junkj.module.file.biz.FileUploadBiz;
import com.junkj.module.file.entity.FileUpload;

public class FileUploadUtils {

	public static FileUploadBiz fileUploadBiz = SpringUtils.getBean(FileUploadBiz.class);

	public static String saveFileUpload(final String bizId, final String bizType) {
		// 更新文件
		String imgs = ServletUtils.getParameter(bizType);
		if (StrUtils.notBlank(imgs)) {
			String[] arr = imgs.split(",");
			for (String id : arr) {
				FileUpload upload = fileUploadBiz.get(id);
				if (StrUtils.notBlank(upload)) {
					upload.setBizId(bizId);
					upload.setBizType(bizType);
					fileUploadBiz.update(upload);
				}
			}
		}
		// 删除文件
		String imgs_del = ServletUtils.getParameter(bizType + "_del");
		if (StrUtils.notBlank(imgs_del)) {
			String[] arr = imgs_del.split(",");
			for (String id : arr) {
				fileUploadBiz.delete(new FileUpload(id));
			}
		}
		// 返回图片地址
		FileUpload fileUpload = new FileUpload();
		fileUpload.setBizId(bizId);
		fileUpload.setBizType(bizType);
		List<FileUpload> a = fileUploadBiz.findList(fileUpload);
		if (a != null && a.size() > 0) {
			return a.get(0).getFileUrl();
		}
		return null;
	}

	// 下载远程图片到本地
	public static String downloadImg(String urlStr) throws Exception {
		// 上传根目录
		String filePath = PathUtils.getDatePath();
		String fileDir = Global.getFileDir(filePath);
		String fileId = IdGenerate.nextId();
		String fileName = fileId.concat(".jpg");
		String idDir  = fileDir.concat(fileName);
		// 构造URL
		URL url = new URL(urlStr);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream is = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf = new File(fileDir);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(idDir);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
		return Global.fileUri() + Global.UPLOAD_PATH + filePath + fileName;
	}

	public static List<FileUpload> findFileUpload(String bizId, String bizType) {
		if (StrUtils.isNotBlank(bizId) && StrUtils.isNotBlank(bizType)) {
			FileUpload fileUpload = new FileUpload();
			fileUpload.setBizId(bizId);
			fileUpload.setBizType(bizType);
			return fileUploadBiz.findList(fileUpload);
		}
		return null;
	}
}
