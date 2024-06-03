package com.hrportal.dao;

import com.hrportal.dto.CredetialsDto;
import com.hrportal.dto.LoginPojo;
import com.hrportal.dto.ResponsePojo;
import com.hrportal.dto.UserPojo;

public interface AdminDao {

	public ResponsePojo test(LoginPojo pojo);
	
	public ResponsePojo login( CredetialsDto dto);
}
