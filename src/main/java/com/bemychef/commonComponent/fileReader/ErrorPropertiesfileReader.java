package com.bemychef.commonComponent.fileReader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties()
@PropertySource({"classpath:userErrorMessage.properties"})
public class ErrorPropertiesfileReader {
	
	private static final Map<String, String> errorMap = new HashMap<>();

	
	
	public  Map<String, String> getErrorMap() {
		return errorMap;
	}
	
	public static String getDataByKey(String key) {
		return errorMap.get(key);
	}

	

}
