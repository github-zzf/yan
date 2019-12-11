package com.junkj.module.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junkj.common.form.FormToken;

/**
 * @description
 */
@RestController
public class TestController {
	int x = 0;

	@FormToken
	@RequestMapping(value = "/test/d", method = RequestMethod.GET)
	public Map<String, Object> test(HttpServletRequest request) {
		System.out.println(++x);

		Random r = new Random();
		int i = r.nextInt(3);
		if (i == 2) {
//			throw new CustomException("有异常");r
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute("request Url", request.getRequestURL());
		map.put("request Url", request.getRequestURL()+"="+x);
		return map;
	}

}
