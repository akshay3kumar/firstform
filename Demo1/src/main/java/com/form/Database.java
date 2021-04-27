package com.form;

import java.sql.*;






public class Database {
	
	private String fname;
	private String lname;
	private String email;
	private String mob;
	private String pass;
	
	public Database() {}
	
	
	public Database(String fname, String lname, String email, String mob, String pass) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mob = mob;
		this.pass = pass;
	}

	

	public  void save() throws Exception{
		String url="jdbc:mysql://localhost:3306/mydata";
		String user="root";
		String password="password";
		
		System.out.println("error");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("error2");
		Connection con=(Connection) DriverManager.getConnection(url,user,password);
		
		PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into data values(?,?,?,?,?);");
		
		
				stmt.setString(1,fname);//1 specifies the first parameter in the query  
				stmt.setString(2,lname); 
				stmt.setString(3,email);
				stmt.setString(4,mob);
				stmt.setString(5,pass); 
				  
				int i=stmt.executeUpdate();  
				System.out.println(i+" records inserted");  
				
				con.close();
		

	}
	public String validateUser(String username,String pass1) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/mydata";
		String user="root";
		String password="password";
		String r="";
		boolean t=false;
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=(Connection) DriverManager.getConnection(url,user,password);
		
		String queryString = "SELECT email, password FROM data";
		Statement st=con.createStatement();
        ResultSet results = st.executeQuery(queryString);
        
        while (results.next()) {
            String uname = results.getString(1);
            String pass2 =  results.getString(2);
            
               if ((username.equals(uname)) && (pass1.equals(pass2))) {
            	
            	   PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select first_name, last_name from data where email=?");

                 stmt.setString(1, uname);
                 ResultSet rs=stmt.executeQuery();
                 rs.next();
                 String finame=rs.getString("first_name");
                 String laname=rs.getString("last_name");
                 rs.close();
                 
                 r= (finame+laname);
                 t=true;
                 break;
            	   
                 
            }
             
        }
        		if(t) {
        			System.out.println("success");
        		}
               else {
            	  r= "not found";
            	  System.out.println(r);
             //JonPane.showMessageDialog(null, "Please Check Username and Password ");
            }
            
         
        results.close();
        con.close();
        System.out.println(r);
        return r;
		
		
	}

}
