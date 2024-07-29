package com.flight.adminManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableDiscoveryClient
public class AdminMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminMicroserviceApplication.class, args);
	}

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
