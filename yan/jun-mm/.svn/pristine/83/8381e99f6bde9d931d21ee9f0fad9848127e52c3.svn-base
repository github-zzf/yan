package com.junkj.module.file.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.file.biz.FileUploadBiz;
import com.junkj.module.file.entity.FileUpload;
import com.junkj.module.file.entity.FileUploadParams;

@Controller
@RequestMapping({ "${adminPath}/file" })
public class FileUploadAction extends BaseAction {

	@Autowired
	private FileUploadBiz fileUploadBiz;

	@RequestMapping({ "upload" })
	@ResponseBody
	public FileUpload upload(FileUploadParams params) {
		return this.fileUploadBiz.uploadFile(params);
	}

	@RequestMapping({ "fileList" })
	@ResponseBody
	public JsonVo fileList(FileUpload fileUpload) {
		if (StrUtils.isNotBlank(fileUpload.getBizId()) && StrUtils.isNotBlank(fileUpload.getBizType())) {
			List<FileUpload> a = fileUploadBiz.findList(fileUpload);
			if (a != null && a.size() > 0) {
				return sendData(a);
			}
		}
		return sendError("没有文件");
	}

	@RequestMapping(value = { "download/{fileUploadId}" }, method = { RequestMethod.GET })
	public String download(@PathVariable("fileUploadId") final String fileUploadId, final String preview,
			final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		FileUpload a = fileUploadBiz.get(fileUploadId);
		if (a != null && a.getFileEntity() != null && a.getFileEntity().getFileMd5() != null) {
			if (StrUtils.isNotBlank(preview)) {
				final String a3 = a.getFileUrl();
				final String a2 = StrUtils.contains(a3, "?") ? "&" : "?";
				return new StringBuilder().insert(0, "redirect:").append(a3).append(a2).append("preview=")
						.append(preview).toString();
			}
			String a3 = fileUploadBiz.getFileUploadServiceExtend().downFile(a, request, response);
			if (!"404".equals(a3)) {
				if (StrUtils.isNotBlank(a3)) {
					return new StringBuilder().insert(0, "redirect:").append(a3).toString();
				}
				return null;
			}
		}
		request.setAttribute("responseStatus", 200);
		request.setAttribute("message", "sys.file.downloadFileNotExist");
		request.getRequestDispatcher("/error/404").forward(request, response);
		return null;
	}
}
