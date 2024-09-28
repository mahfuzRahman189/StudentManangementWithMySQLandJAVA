package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DB {
	Connection con;
	Scanner sc=new Scanner(System.in);
      public DB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learning","root","mrm189");
			System.out.println("Database Connected");
		} 
		catch(Exception e) {
			System.out.println(e);
		}
	}
    
   
    
   public void read() {
    	String cmd2="Select * From Student";
    	concoleClear();
    	System.out.println("Printing from database: ");
    	System.out.println(String.format("%-15s%-20s%-20s","ID","Name","Grade"));
	    System.out.println("----------------------------------------");
    	try {
    	Statement stmt=con.createStatement();
    	ResultSet rs=stmt.executeQuery(cmd2);
		while(rs.next())
		{
			System.out.println(String.format("%-15s%-20s%-20s",rs.getString("ID"),rs.getString("S_name"),rs.getFloat("Grade")));
		}
		stmt.close();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }
    
    public void insert() {
    	System.out.print("Enter name: ");
    	String name=sc.nextLine();
    	System.out.print("Enter grade: ");
    	float grade=sc.nextFloat();
    	String cmd="Insert into Student(S_name,Grade) values('"+name+"',"+grade+")";
    	
    	try {
    		Statement stmt=con.createStatement();
    		stmt.execute(cmd);
    		stmt.close();
    		System.out.println("Data inserted");
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
   public void update() {
    	System.out.print("Enter ID to update: ");
    	int id=sc.nextInt();
    	System.out.print("What do you want to update?\n1.Name\n2.Grade\nPress the number: ");
    	int det=sc.nextInt();
    	sc.nextLine();
    	try {
    	 Statement stmt=con.createStatement();
    	String cmd;
    	switch(det){
    	case 1:
    		System.out.print("Enter new name: ");
    		String c1=sc.nextLine();
    		cmd="update Student set S_name='"+c1+"' where ID="+id;
    		stmt.execute(cmd);
    		stmt.close();
    		System.out.println("Data Updated");
    		break;
    	case 2:
    		System.out.print("Enter new grade: ");
    		float c2=sc.nextFloat();
    		cmd="update Student set Grade="+c2+" where ID="+id;
    		stmt.execute(cmd);
    		stmt.close();
    		System.out.println("Data Updated");
    		break;
    	default:
    			System.out.println("invalid input");
    	}
    	
    	
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void delete() {
    	System.out.println("Enter ID to delete: ");
    	int id=sc.nextInt();
    	String cmd="delete from Student where ID="+id;
    	try {
    		Statement stmt=con.createStatement();
    		stmt.execute(cmd);
    		stmt.close();
    		System.out.println("Data deleted");
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void concoleClear() {
    	 for (int i = 0; i < 50; i++) {
             System.out.println();
         }
    }
}
