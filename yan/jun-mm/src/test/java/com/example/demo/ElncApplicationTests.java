package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class ElncApplicationTests {

	// spring的RestTemplate，它实现的是RestOperations接口，里面有好多方法，即get,post,put,delete。
	private RestTemplate template = new RestTemplate();

	@Test
	public void contextLoads() {
		// 异常处理
		try {
			String url = "http://localhost:8080/api/getMySaleTatol?userId=1";
			ResponseEntity<String> r = template.getForEntity(url, String.class);
			System.err.println(r.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
