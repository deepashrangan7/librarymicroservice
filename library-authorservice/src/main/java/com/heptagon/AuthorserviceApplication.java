package com.heptagon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.heptagon")
@EnableDiscoveryClient
@EnableFeignClients("com.heptagon")
public class AuthorserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthorserviceApplication.class, args);
	
	}
}