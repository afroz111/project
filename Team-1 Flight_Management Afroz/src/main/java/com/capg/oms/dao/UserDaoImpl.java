package com.capg.oms.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.oms.model.User;

public class UserDaoImpl implements UserDao {

	Map<Long,User> userList=new HashMap<Long , User>();
	
	public void addSomeAdmins() {
		User admin1=new User(1234L,"Afroz","afroz624",9542785713L,"afroz@gmail.com");
		User admin2=new User(1235L,"Charan","charan624",7097716221L,"@gmail.com");
		userList.put(admin1.getUserId(),admin1);
		userList.put(admin2.getUserId(),admin2);
	}
	
	public void addSomeCustomers() {
		User customer1=new User(123456L,"Afroz","afroz624",9542785713L,"afroz@gmail.com");
		User customer2=new User(123567L,"charan","charan624",7097716221L,"charan@gmail.com");
		userList.put(customer1.getUserId(),customer1);
		userList.put(customer2.getUserId(),customer2);
	}
	

	public boolean addUser(User user) {
		if(userList.containsKey(user.getUserId())){
			return false;
		}
		userList.put(user.getUserId(), user);
		return true;
	}

	public List<User> viewUser() {
		
		List<User> listOfUsers = new ArrayList<User>();
		for(Long l:userList.keySet()) {
			listOfUsers.add(userList.get(l));
		}
		return listOfUsers;
	}

	public Map<Long, User> getUser() {
		return userList;
	}
	public User viewUser(long userId) {
		
		if(userList.containsKey(userId)) {
			return userList.get(userId);
		}
		return null;
	}

	
}
