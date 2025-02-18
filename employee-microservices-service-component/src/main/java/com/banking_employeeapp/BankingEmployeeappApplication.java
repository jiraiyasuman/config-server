package com.banking_employeeapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Employee REST API Documentation",
				description = "Spring Boot Employee REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Suman Talukdar",
						email = "suman.talukdar53@gmail.com",
						url = ""
				),
				license = @License(
						name = "Apache 2.0",
						url = ""
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Emloyee Management Documentation",
				url = ""
		)
		)
@EnableDiscoveryClient
public class BankingEmployeeappApplication {

	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */
	/*
	 * @Bean public WebClient webClient() { return WebClient.builder().build(); }
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(BankingEmployeeappApplication.class, args);
	}

}
