
package com.capg.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Application starts from here
@SpringBootApplication                      

public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		System.out.println("Spring Application Started");
	}

}
