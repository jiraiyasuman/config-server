package com.banking_employeeapp.globalexception;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private long timestamp;
	private String message;
}
