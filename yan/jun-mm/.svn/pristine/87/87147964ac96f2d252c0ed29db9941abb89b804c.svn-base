package com.junkj.module.file.biz;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = { "file.enabled" }, havingValue = "true", matchIfMissing = true)
public class FileAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public FileUploadBizExtend fileUploadBizExtend() {
		return new FileUploadBizExtend();
	}

	@Bean
	@ConditionalOnMissingBean
	public FileUploadBiz fileUploadService() {
		return new FileUploadBiz();
	}

	@Bean
	@ConditionalOnMissingBean
	public FileEntityBiz fileEntityService() {
		return new FileEntityBiz();
	}

}
