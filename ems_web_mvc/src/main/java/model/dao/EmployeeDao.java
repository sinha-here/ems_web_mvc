package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.entity.Employee;

@Component
public class EmployeeDao {
	
	@Autowired
	DbConfig db;
	
	
	Query query;
	
	public boolean adminValidate(Employee emp) {
		
		Employee e = db.em.find(Employee.class, emp.getId()); 
		
	if(e!=null) {
		if(e.getPassword().equals(emp.getPassword()) && e.getRole().equalsIgnoreCase("admin")) {
			return true;
		}
	}
		return false;
	}
	
	
	public int employeeExist(Employee e) {
		query = db.em.createQuery("select e from Employee e where e.phone = ?1");
		query.setParameter(1, e.getPhone());
		List<Employee> emps = query.getResultList();
		return emps.size();
		
	}
	
	public boolean addEmployee(Employee e) {
		
		int before = employeeExist(e);
		
		e.setId(0);
		if(before == 0) {
			db.et.begin();
					db.em.merge(e);
			db.et.commit();
			
			
			
			int after = employeeExist(e);
			
			if(after != 0 ) {
				return true;
			}
		}
		return false;
	}
	
	
	public Employee viewEmployee(int id) {
		Employee emp = db.em.find(Employee.class, id);
		
		return emp;
	}
	
	public List<Employee> viewAllEmp(){
		query = db.em.createQuery("select e from Employee e");
	 List<Employee> emp =query.getResultList();
	 
	 if(! emp.isEmpty()) {
		 return emp;
	 }
	 
	 else {
		 return null;
	 }
	}
//	public List<Employee> viewAllEmp() {
//	    Query query = db.em.createQuery("SELECT e FROM Employee e");
//	    List<Employee> empList = query.getResultList();
//	    
//	    return empList != null ? empList : new ArrayList<>(); // Return empty list if null
//	}
	
	public boolean removeEmployee(int id) {
		Employee emp =  db.em.find(Employee.class, id);
		
		if(emp!=null) {
			db.et.begin();
				db.em.remove(emp);
			db.et.commit();
			
			
			if(db.em.find(Employee.class, id) == null) {
				return true;
			}
		}
		
		return false;
		
		
	}
	
	public boolean updateEmployee(Employee emp) {
		Employee existing  =  db.em.find(Employee.class, emp.getId());
		if(existing!=null) {
			db.et.begin();
			db.em.merge(emp);
		db.et.commit();
		
		if(db.em.find(Employee.class, emp.getId()).toString().equals(emp.toString())) {
			return true;
		}
		
		}
		return false;
	}

}
