package com.bemychef.commonComponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bemychef.commonComponent")
public class CommonComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonComponentApplication.class, args);
	}

}
