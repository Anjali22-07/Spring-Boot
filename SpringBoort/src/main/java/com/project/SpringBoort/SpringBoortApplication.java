package com.project.SpringBoort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.SpringBoort.controller")
public class SpringBoortApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoortApplication.class, args);
	}

}
