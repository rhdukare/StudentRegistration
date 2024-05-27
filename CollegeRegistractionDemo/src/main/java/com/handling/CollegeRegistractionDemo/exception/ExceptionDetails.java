package com.handling.CollegeRegistractionDemo.exception;

import java.util.Date;

public class ExceptionDetails {
	
	private Date timespace;
	private String message;
	private String details;
	public Date getTimespace() {
		return timespace;
	}
	public void setTimespace(Date timespace) {
		this.timespace = timespace;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ExceptionDetails() {
		super();
	}
	public ExceptionDetails(Date timespace, String message, String details) {
		super();
		this.timespace = timespace;
		this.message = message;
		this.details = details;
	}
	

}
