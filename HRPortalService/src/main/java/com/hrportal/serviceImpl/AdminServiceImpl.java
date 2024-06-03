package com.hrportal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrportal.dao.AdminDao;
import com.hrportal.dto.CredetialsDto;
import com.hrportal.dto.LoginPojo;
import com.hrportal.dto.ResponsePojo;
import com.hrportal.dto.UserPojo;
import com.hrportal.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;


	@Override
	public ResponsePojo test(LoginPojo pojo) {
		return dao.test(pojo);
	}

	@Override
	public ResponsePojo login(CredetialsDto dto) {
		return dao.login(dto);

	}

}
