package com.capg.login.Dao;

import java.util.List;

import com.capg.login.Entity.AdminLogin;
import com.capg.login.Entity.UserBean;

//Here we are just designing the methods which will be implemented in another layer of this packageS
public interface IUserDao {
	
	public UserBean addNewUser(UserBean bean);
	//public List<AdminLogin> adminLogin(String name,String password);
	//public UserBean userLogin(String userName,String password);

	//public List<UserBean> findByUserBean(String userName, String password);
	public List<UserBean> userLogin(int id,String name, String password);
//public String loggs(String name,String password);
public List<UserBean> getAll();
	
}
