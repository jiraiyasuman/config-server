package com.banking_microservices_department.globaleceptionhandler;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private long timestamp;
	private String message;
}
