package com.empresa.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "sonia2022";
		String encodedPassword = encoder.encode(password);
		
		System.out.println();
		System.out.println("Password is         : " + password);
		System.out.println("Encoded Password is : " + encodedPassword);
	
	}
}
