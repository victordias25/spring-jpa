package com.br.ecommerce.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication(scanBasePackages = "com.br.ecommerce.springjpa")
@EntityScan(basePackages = "com.br.ecommerce.springjpa.model")
@EnableCaching
public class SpringJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
}
