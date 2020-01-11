package com.bemychef.commonComponent.fileReader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties()
@PropertySource({"classpath:userSuccessMessage.properties"})
public class UserSeccessMessagePropertiesFileReader {
	private static final Map<String, String> successMap = new HashMap<>();

	public  Map<String, String> getSuccessmap() {
		return successMap;
	}
	
	public static String getDataByKey(String key) {
		return successMap.get(key);
	}
	
	
}
