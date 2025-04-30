package com.raffi_estoque;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableFeignClients
public class RaffiEstoqueApplication {
	public static void main(String[] args) {
		SpringApplication.run(RaffiEstoqueApplication.class, args);
	}

}
