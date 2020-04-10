package com.firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.firebase.*")
//@ComponentScan(basePackageClasses = "com.*")
public class FireBaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireBaseDemoApplication.class, args);
	}

}
