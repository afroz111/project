package com.capg.login.Controller;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.login.Dao.UserDaoImpl;
import com.capg.login.Entity.UserBean;
import com.capg.login.Service.UserServiceImpl;
@SpringBootTest
class LoginTest {
	@Autowired
	UserServiceImpl service;
	@Autowired
	UserDaoImpl dao;
	static UserBean bean;
	
	@Test
	void testValdateUserName() {
	assertEquals(true, service.validateUserPassword("MohammedAfroz"));
	}

	@Test
	void testValidateUserPassword() {
		assertEquals(true, service.validateUserPassword("Afroz624@"));
	}

	@Test
	void testValidateUserEmail() {
		assertEquals(true, service.validateUserEmail("afrozmohammed624@gmail.com"));
	}

	@Test
	void testValidateUserPhoneNo() {
		assertEquals(true, service.validateUserPhoneNo(9542785713l));
	}

}
