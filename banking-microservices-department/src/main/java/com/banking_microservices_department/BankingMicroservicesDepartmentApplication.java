package com.banking_microservices_department;

import org.modelmapper.ModelMapper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Department REST API Documentation",
				description = "Spring Boot Department REST API Documentation",
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
				description = "Spring Boot Department Management Documentation",
				url = ""
		)
		)
@EnableDiscoveryClient
@SpringBootApplication
public class BankingMicroservicesDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingMicroservicesDepartmentApplication.class, args);
	}

}
