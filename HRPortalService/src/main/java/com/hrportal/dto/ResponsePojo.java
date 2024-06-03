package com.hrportal.dto;

import java.util.Map;

import lombok.Data;

@Data
public class ResponsePojo {

	private Boolean status;
	private String message;
	private Object data;
	private Map<String, Object> extraParams;

}
