package com.statebank.xoriant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
 
public class ManagerServiceApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(ManagerServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ManagerServiceApplication.class, args);
		System.out.println("in manager main service..!");
		  LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
		  LOGGER.error("Simple LOGGER");
	}

}
