package com.Laboratory.Laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // This annotation is used to MiddlewareManager class to be able to work
public class LaboratoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryApplication.class, args);
	}

}
