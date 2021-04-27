package com.form;

public class LogIn {
	private String uname;
	private String pass;
	
	public LogIn() {}
	public LogIn(String uname, String pass) {
		
		this.uname = uname;
		this.pass = pass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String validate()
	{
		String result="";
		Database db=new Database();
		try {
			result=db.validateUser(uname,pass);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		if(result.equals("not found"))
				return "index4";
		else {
			
			return "index2";
		}
			
	}
	

}
