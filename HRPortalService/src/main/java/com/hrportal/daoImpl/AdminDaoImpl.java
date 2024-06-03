package com.hrportal.daoImpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrportal.config.PasswordHelper;
import com.hrportal.dao.AdminDao;
import com.hrportal.dto.CredetialsDto;
import com.hrportal.dto.LoginPojo;
import com.hrportal.dto.ResponsePojo;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private PasswordHelper decrypter;

	@Override
	public ResponsePojo test(LoginPojo pojo) {
		ResponsePojo response = new ResponsePojo();
		try {
			response.setMessage("Hello World");
			response.setStatus(true);

			response.setData(Arrays.asList("Gomtesh", "Shiva", "Uday", "Hari"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public ResponsePojo login(CredetialsDto dto) {
		ResponsePojo responsePojo = new ResponsePojo();
		try {
			responsePojo.setStatus(true);
			responsePojo.setData(Arrays.asList("Gomtesh", "Shiva", "Uday", "Hari"));
			String key = decrypter.generateSecretKey();
			String iv = decrypter.generateIV();

			String enString = decrypter.encrypt("Gomtesh", key, iv);
			String deString = decrypter.encrypt(enString, key, iv);

			System.err.println("encryt==>" + enString);
			System.err.println("Decrypt==>" + deString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsePojo;
	}

}
