package model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Employee {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id ;
	
	
	private String name;
	private double salary;
	private long phone;
	private String password;
	private String role;
	
	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String name, double salary, long phone, String password, String role) {
		this(name, salary, phone,password,role);
		this.id = id;
		
	}


	public Employee(String name, double salary, long phone, String password, String role) {
		super();
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
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
