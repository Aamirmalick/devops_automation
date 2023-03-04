package com.simpleapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ @PropertySource("classpath:message.properties")})

public class SpringbootTestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestAppApplication.class, args);
		Logger loginfo=LoggerFactory.getLogger(SpringbootTestAppApplication.class);
		loginfo.info("TodoList-Service is Starting!.....");
		loginfo.debug("No Error Found! While Starting the App!...");
		loginfo.warn("Successfully!....Started!.....");
	}

}
