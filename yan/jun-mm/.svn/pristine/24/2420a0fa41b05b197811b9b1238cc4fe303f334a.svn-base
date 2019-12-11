package com.junkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("com.junkj.module.*.dao")
public class JunMmApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JunMmApplication.class, args);
	}

	/**
	 * 新增此方法
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		this.setRegisterErrorPageFilter(false);
		return builder.sources(JunMmApplication.class);
	}
	
}
