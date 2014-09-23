package model;

import java.io.*;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String email;
	
	public Account(String name,String password,String email){
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public Account(){}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

}
