package com.junkj.common.ueditor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.junkj.common.ueditor.ActionEnter;
import com.junkj.common.utils.PathUtils;

@WebServlet(name = "UEditorServlet", urlPatterns = "/static/common/ueditor/jsp/controller")
public class UeditorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String rootPath = PathUtils.getRootPath();
		try {
			String exec = new ActionEnter(request, rootPath).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

	}

}
