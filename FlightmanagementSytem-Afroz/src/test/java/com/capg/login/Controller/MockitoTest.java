package com.capg.login.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.login.Dao.UserDaoImpl;
import com.capg.login.Entity.AdminLogin;
import com.capg.login.Entity.UserBean;
import com.capg.login.Service.UserServiceImpl;


//@RunWith()
@SpringBootTest
class MockitoTest {
	
	

	@Autowired //setter and constructor injection handle 
	private UserServiceImpl serviceImp;
	
	
	@MockBean
	private UserDaoImpl daoImp;
	
	UserBean bean = new UserBean();
	AdminLogin login=new AdminLogin();
	

	@Test //It describe that testing have been intitate 
	void testAddUsers() { //Regestration 
		bean.setUserId(425);
		bean.setUserName("MohammedAfroz");
		bean.setPassword("Afroz624@");
		bean.setUserPhone("9542785713");
		bean.setUserEmail("Afrozmohammed111@gmail.com");
		Mockito.when(daoImp.addNewUser(bean)).thenReturn(bean);
		assertThat(serviceImp.addNewUser(bean)).isEqualTo(bean);
	}


	
	@Test
	void testGetall() { // for grt all users .
		UserBean bean1=new UserBean();
		bean1.setUserId(426);
		bean1.setUserName("MohammedRizwan");
		bean1.setPassword("Rizwan624@");
		bean1.setUserPhone("8542785713");
		bean1.setUserEmail("Rizwanmohammed111@gmail.com");
		
		
		UserBean bean2=new UserBean();
		bean2.setUserId(427);
		bean2.setUserName("AshutoshDhondi");
		bean2.setPassword("Ashutosh624@");
		bean2.setUserPhone("7542785713");
		bean2.setUserEmail("ashutoshdhondi111@gmail.com");
		  List<UserBean> viewList=new  ArrayList();
		  viewList.add(bean1);
		  viewList.add(bean2);
		  Mockito.when(daoImp.getAll()).thenReturn(viewList);
		  assertThat(serviceImp.getAll()).isEqualTo(viewList);
		  assertEquals(viewList.size(), 2);
		
	}

}
