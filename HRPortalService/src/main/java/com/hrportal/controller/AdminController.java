package com.hrportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrportal.dto.CredetialsDto;
import com.hrportal.dto.LoginPojo;
import com.hrportal.service.AdminService;

@CrossOrigin
@RequestMapping("admin")
@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping("test")
	public ResponseEntity<Object> test() {
		return new ResponseEntity<>(service.test(new LoginPojo()), HttpStatus.OK);
	}

//
	@PostMapping("login")
	public ResponseEntity<Object> login(@RequestBody CredetialsDto dto) {
		return new ResponseEntity<>(service.login(dto), HttpStatus.OK);
	}

}
