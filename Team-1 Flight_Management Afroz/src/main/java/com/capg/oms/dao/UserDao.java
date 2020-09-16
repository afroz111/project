package com.capg.oms.dao;

import java.util.List;
import java.util.Map;

import com.capg.oms.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public List<User> viewUser();
	public Map<Long,User> getUser();
	public User viewUser(long userId);
	public void addSomeAdmins();
	public void addSomeCustomers();

}
