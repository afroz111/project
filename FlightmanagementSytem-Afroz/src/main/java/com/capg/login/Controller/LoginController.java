package com.capg.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.login.exceptions.InvalidInputException;
import com.capg.login.Entity.UserBean;
import com.capg.login.Service.IUserService;


//These @CrossOrigin will help us to connect with the angular with help of the above url
@CrossOrigin(origins = "http://localhost:4200")

//Instead of using @Controller and @ResponseBody we use the @RestController which means it is 
//a combination of @Controller and @ResponseBody
@RestController

public class LoginController {
	
	@Autowired    //This annotation is  here we are using for service automatic object creation 
	
	IUserService service;

	
	@PostMapping("user/reg")
	public String addUsers(@RequestBody  UserBean bean) {   ///here this registration page
		UserBean bean1=service.addNewUser(bean);

		
			return "Hello " +bean1.getUserName()+"  your  Registered is sucessfully "+"\n"+"Your Id is:"+bean1.getUserId();
	}

	
	@GetMapping("/adminlogin/{name}/{password}")   //Admin login concept
public String adminLogin(@PathVariable String name,@PathVariable String password) throws Exception{
		if(name==null||password==null) 
			//throw new InvalidInputException("Name and Password cant be empty");
               return "Name and Password cant be empty";
	
		else if(name.equals("Afroz111")&&password.equals("Afroz624@")||name.equals("Ashutosh111")&&password.equals("Ashutosh111@"))		
	
	return "Login Sucessful...!";
		else 
			return "Invalid name or password";
		
	}
		
	
		 
	@GetMapping("/userLogin/{id}/{name}/{password}")    //we are check   login with id,name and password
	public String userLogin(@PathVariable int  id,@PathVariable String name,@PathVariable String password)throws InvalidInputException {
		
		
		List<UserBean> bean2= service.userLogin(id,name, password);
		
		boolean flag=false;
		for(UserBean userbean: bean2) {
			if(name==null||password==null) {
			throw new InvalidInputException("name or password cannot be Empty");
			}
		else if(userbean.getUserId()==id&&userbean.getUserName().equals(name.trim())&&userbean.getPassword().equals(password.trim())) {
				flag=true;
				break;
			}
			
		}

	
	if(flag==true)
		return("Login Sucessfully......!!! Welcome to AfrozFlights");
	
	return "Invalid Id or name or password! Try Again...! If not a user please Register.";
	
	}
	
	
	/*@GetMapping("/Login1/{name}/{password}")
		public String logg(@PathVariable String name,@PathVariable String password) {
			String been=service.loggs(name, password);
			
			return "Invalid name or password";
		
	}*/
	@GetMapping("user/findall")   //here using for get all data from database      
	public List<UserBean> getall() {

		List<UserBean> bean = service.getAll();
		return bean;
	}



}
