package com.mm.api;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.mm.api.*")
public class EmailApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}