package com.claim.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	
	//Adding Annotations for primary Examples
	@Id
	@Column(name="email", length=100)
	private String email;						//The @Column allows you to specify the column mapping
	
	//Adding Annotations for primary Examples
	@Column(name="first_name")
	private String fName;
	
	//Adding Annotations for primary Examples
	@Column(name="last_name")
	private String lName;
	
	//Adding Annotations for primary Examples
	@Column(name="age")
	private int age;
	
	//Adding Annotations for primary Examples
	@Column(name="phone_number")
	private String pNumber;
	
	@Column(name="role")
	private String role;
	

	
	
	@Column(name="password")
	private String password;
	
	public User() {
		
	}
		
		
	
	
	//Getters and Setters	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
