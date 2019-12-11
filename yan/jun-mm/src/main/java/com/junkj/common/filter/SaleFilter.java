package com.junkj.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.MemberUtils;
import com.junkj.common.utils.UserUtils;
import com.junkj.module.sys.entity.SysUser;

public class SaleFilter extends BaseFilter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean ck = checkUser(response);
		if (ck == false) {
			return false;
		}

		// 登录绑定验证
		String path = request.getServletPath();
		if (path.indexOf("/sale/saleLogin") == -1) {
			if (StrUtils.isBlank(MemberUtils.getSaleId())) {
				sendError(response, "未登录", 403);
				return false;
			} else {
				// 用户验证
				SysUser u = UserUtils.get(MemberUtils.getSaleId());
				if (u == null || !u.getComId().equals(ComUtils.getCurrentComId())) {
					sendError(response, "未登录", 403);
					return false;
				}
			}
		}

		return true;
	}

}