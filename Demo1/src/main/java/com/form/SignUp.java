package com.form;

import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@ManagedBean
@SessionScoped
public class SignUp {
	
	protected String fname;
	protected String lname;
	protected String email;
	protected String mob;
	protected String password;
	
	
	//Constructor
	public SignUp() {}
	
	public SignUp(String fname, String lname, String email, String mob,String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mob = mob;
		this.password=password;
	}

	
	//Getters and Setters

	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMob() {
		return mob;
	}


	public void setMob(String mob) {
		this.mob = mob;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String nextPage()
	{
		return "index.xhtml";
	}
	
	
	public String saveInDataset() throws Exception
	{
		Database db=new Database(fname,lname,email,mob,password);
		try {
			db.save();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
				return "index";
				
	}
	

}
