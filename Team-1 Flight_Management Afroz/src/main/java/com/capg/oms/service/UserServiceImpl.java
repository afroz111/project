package com.capg.oms.service;

import java.util.List;
import java.util.Map;

import com.capg.oms.dao.UserDao;
import com.capg.oms.dao.UserDaoImpl;
import com.capg.oms.model.User;
import com.capg.oms.ui.LoginUser;

public class UserServiceImpl implements UserService {
	//LoginUser l=new LoginUser();
	static UserDao dao=new UserDaoImpl();
	
	public boolean addUser(User user) {
		return dao.addUser(user); 
	}

	public List<User> viewUser() {
		return dao.viewUser();	
	}

	public Map<Long, User> getUser() {
		return dao.getUser();	
	}

	public User viewUser(long userId) {
		return dao.viewUser(userId);	
	}

	public void initialAdminList() {
		dao.addSomeAdmins();
	}
	
	public void initialCustomerList() {
		dao.addSomeCustomers();
	}
	
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException {
		String s=Long.toString(phoneNo);
		if(s.length()==10 && s.charAt(0)!=0)
			return true;
		else
			throw new InvalidDetailsException("Invalid Phone Number");
		
		//l.login();
	}

	public boolean validateEmail(String email) throws InvalidDetailsException {
		
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidDetailsException("Invalid email Id");
	   }
	
	public boolean validateCustomerId(long id) throws InvalidDetailsException {
		int count=0;
		while(id>0) {
			long d=id % 10;
			count++;
			id=id/10;
		}
		if(count==6)
			return true;
		else
			throw new InvalidDetailsException("Invalid ID.. Please try Again......");	
	}

	public boolean validatePassword(String pw) throws InvalidDetailsException {
		if(pw.length()==8) {
			return true;
		}
		else {
			throw new InvalidDetailsException("Password should be of minimun 8 characters..Please try Again...");
		}
	}


}
 