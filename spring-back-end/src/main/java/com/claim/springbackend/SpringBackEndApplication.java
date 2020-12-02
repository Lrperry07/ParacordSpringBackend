package com.claim.springbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

	//Added
@ComponentScan(basePackages="com.claim")

@SpringBootApplication
public class SpringBackEndApplication {

	
//		Main Method
	public static void main(String[] args) {
		SpringApplication.run(SpringBackEndApplication.class, args);
	}

}
