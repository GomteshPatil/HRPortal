package com.hrportal.dto;

public record CredetialsDto(String userName, String password) {

	public String userName() {
		return userName;
	}

	public String password() {
		return password;
	}

}
