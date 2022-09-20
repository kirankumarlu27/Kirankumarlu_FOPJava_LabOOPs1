package CredServices;

import java.util.Scanner;  // Scanner is used to read Input in a Java Program.
import java.util.Random;  // Import Random class for generation of Password.

public class Employee {

	private String firstName;	//First name of Employee
	private String lastName;	//Last name of Employee
	private String email;
	private String password;	//Password : Abc@2002 so it took as String
	private int defaultPasswordLength=8; //Length of password i.e 8
	
	private String department;	//Dept where Employee work
	
	private String companySuffix="learningbydoing.com"; // This is used to show the Employee email :abc@greatlearning.com
	
	
	/*Determine the department:1.Technical
	 * 						   2.Admin 
	 * 						   3.Human Resource
	 * 						   4.Legal.
	 */
	
	private String setDepartment() {
		System.out.println("Please Enter The Department From The Following:\n1 Technical \n2 Admin \n3 Human Resource \n4 Legal ");//display dept
		
		Scanner sc =new Scanner(System.in); //Initialize Scanner Class
		int choice = sc.nextInt(); // Choice for Selection of Dept.
		
		// we can use if-else or switch statements.
		if(choice==1) {
			return "technical";
		} 
		else if(choice==2) {
			return "admin";
		}
		else if(choice==3) {
			return "hr";
		}
		else if(choice==4) {
			return "legal";
		}
		else {
			return " ";
		}
}
	
/* Generate a Random password which will contain:1.Number
 * 												 2.Capital Letter, Small letter 
												 3.Special character)*/
	
	
	private String randomPassword(int length) {  //
		String passwordSet= "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@$%&*"; //Combination used to set Password
		char[] password=new char[length]; // password length is set to 8
		for(int i=0;i<length;i++) {  // loop is used to generate password of length 8
			int rand=(int) (Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
// Use parameterized constructor for class Employee, to pass firstName, lastName.
	
	
	public Employee(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	//System.out.println("Email --->"+this.firstName+" "+this.lastName);
		
		
		
//call a method for department, return the department
		
		this.department=setDepartment();
	//System.out.println("Department: "+this.department);
		

//combine element to generate email
		email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@" +department+"."+companySuffix;
	//	System.out.println("Email :"+ email);
		
//call a method that returns a random password
		this.password=randomPassword(defaultPasswordLength);
	//	System.out.println("Password : "+this.password+"\n\n");
		
		
	}
	
// 
	
	
//// Display the generated credentials
	
	public String showinfo() {
		return "Dear "+firstName+" "+lastName+" your generated credentials are as follows"+
				"\n Email ---> "+email+
				"\n Password ---> "+password +"\n";
	}
}

