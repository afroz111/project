package com.capg.oms.ui;

import java.util.Scanner;

import com.capg.oms.model.User;
import com.capg.oms.service.InvalidDetailsException;
import com.capg.oms.service.UserService;
import com.capg.oms.service.UserServiceImpl;

public class LoginUser {
	static Scanner sc=new Scanner(System.in);
	static User user=new User();
	static UserService service=new UserServiceImpl();
	public static void main(String[] args) {
		login();//static login 
	}

	public static void newUser() {
		
		System.out.println("Enter the userId:");
		long id=sc.nextLong();
		service.initialCustomerList();
		if(service.getUser().containsKey(id))
		{
			System.out.println("user already exist..."); 
			login();
		}
		
		try {
			if(service.validateCustomerId(id)) {
				user.setUserId(id);
			}
			System.out.println("Enter the Name: ");
			String name=sc.next()+sc.nextLine();
			user.setUserName(name);
		System.out.println("Enter the password: ");
		String pw=sc.next()+sc.nextLine();
		if(service.validatePassword(pw)) {
			user.setUserPassword(pw);
		}

		
		
		System.out.println("Enter the phone: ");
		long ph=sc.nextLong();
		if(service.validatePhoneNo(ph)) {
			user.setUserPhone(ph);
		}
		
		System.out.println("Enter the email: ");
		String mail=sc.next()+sc.nextLine();
		if(service.validateEmail(mail)) {
			user.setUserEmail(mail);
		}
		
		
		if(service.addUser(user)) {
			System.out.println("Account created Successfully!!!.....you can login into your account now");
			login();
		}
		else {
			System.out.println("User id already exists....");
			login();
		}
		}
		catch (InvalidDetailsException e1) {
			System.out.println(e1.getMessage());
		}
		
	}

	public static void customerLogin() {
		service.initialCustomerList();
		System.out.println("Enter the userId: ");
		long cId = sc.nextLong();
		String cPw=null ;
		if(service.getUser().containsKey(cId)) {
			System.out.println("Enter the password: ");
			cPw = sc.next()+sc.nextLine();
			String p=service.viewUser(cId).getUserPassword();
			if(p.equals(cPw)) {
				System.out.println("Login Successful");
			}
			else {
					System.out.println("Invalid password!!!.....try again");
					System.out.println("If new user then create a new account...");
					login();
			}
		}
		else {
			System.out.println("Invalid Id");
			System.out.println("If new user then create a new account...");
		}		
	}
	
	public static void adminLogin() {
		service.initialAdminList();
		System.out.println("Enter the userId: ");
		long aId = sc.nextLong();
		String aPw=null ;
		if(service.getUser().containsKey(aId)) {
			System.out.println("Enter the password: ");
			aPw = sc.next()+sc.nextLine();
			String p=service.viewUser(aId).getUserPassword();
			if(p.equals(aPw)) {
				System.out.println("Login Successful");
			}
			else {
					System.out.println("Invalid password!!!......try again");
					login();
			}
		}
		else {
			System.out.println("Invalid id");
		}
	}
	
	public static void login() {
		try {
		int ch=1;
		while(ch!=0) {
		
		System.out.println("Choose the type of user : ");
		System.out.println("1 - Admin");
		System.out.println("2 - Customer");
		System.out.println("3 - New User");
		System.out.println("4 -Exit");
		System.out.println("\nEnter your choice");
		int choice=sc.nextInt();
		switch(choice) {
			case 1:
				adminLogin();
				break;
			
			case 2:
				customerLogin();
				break;
				
			case 3:
				newUser();
				break;
			case 4:
				System.out.println("Sucessfully Exit");
				break;
			default:
				System.out.println("Invalid choice");
				break;
		}
		
		}
		}
		
		catch(Exception e) {
			System.out.println("Invalid Input please try again");
			login();
		
		}
		
		
	}
}

	