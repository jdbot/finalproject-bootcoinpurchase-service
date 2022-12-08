package com.nttdata.bootcoinpurchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootcoinpurchaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcoinpurchaseServiceApplication.class, args);
	}

}
