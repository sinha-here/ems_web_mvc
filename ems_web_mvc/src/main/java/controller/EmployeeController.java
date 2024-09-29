package controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;import jakarta.servlet.http.HttpServletResponse;
import model.dao.EmployeeDao;
import model.entity.Employee;

@Controller
public class EmployeeController {
	
	
	@Autowired
	Employee emp;
	
	@Autowired
	EmployeeDao edao;
	
	
//	@GetMapping("/greet")
//	public String greet() {
//		return "greet.jsp";
//	}

	
	@PostMapping("/admin_login")
	public String adminValidate(HttpServletRequest req) {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		emp.setId(id);
		emp.setPassword(password);
		
		if(edao.adminValidate(emp)) {
			return "admin_operation.jsp";
		}
		
		else {
			req.setAttribute("message","Invalid id or password");
			return "admin_login.jsp";
		}
		
	}
	
	
	@PostMapping("/add_emp")
	public String addEmployee(HttpServletRequest req) {
		String name = req.getParameter("name");
		Double salary = Double.parseDouble(req.getParameter("salary"));
		Long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		String role  = req.getParameter("role");
		
		if(edao.addEmployee(emp)) {
			req.setAttribute("message", "Employee added successfully.........");
			return "admin_operation.jsp";
		}
		
		else {
			req.setAttribute("message", "failed to add employee");
			return "add_emps.jsp";
		}
	}
	
	@PostMapping("/view_emp")
	public String viewEmployee(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Employee e = edao.viewEmployee(id);
		
		if(e != null) {
			req.setAttribute("employee", e);
			req.setAttribute("message", " find employee success");
			
		}
		
		else {
			req.setAttribute("employee", null);
			req.setAttribute("message", "failed to find employee");
			
		}
		
		return "view_emp.jsp";
	}
	
	
	@GetMapping("/view_all_emp")
	public String viewAllEmp(HttpServletRequest req) {
		List<Employee> emps = edao.viewAllEmp();
		
		if(emps != null) {
			req.setAttribute("employee", emps);
			return "view_all_emp.jsp";
		}
		
		
		req.setAttribute("message", "no data present");
		return "admin_operation.jsp";
		
	}
	
	@GetMapping("/remove_emp")
	public void removeEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id =  Integer.parseInt(req.getParameter("id"));
			
			RequestDispatcher rd = req.getRequestDispatcher("view_all_emp");
			
			if(edao.removeEmployee(id)) {
				req.setAttribute("message", "employee removed succes");
			}
			else {
				req.setAttribute("message", "failed to remove employe");
			}
			
			rd.forward(req, resp);
	}
	
	@PostMapping("/update_emp")
	public void updateEmploye(HttpServletResponse resp, HttpServletRequest req) throws IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			Double salary = Double.parseDouble(req.getParameter("salary"));
			Long phone = Long.parseLong(req.getParameter("phone"));
			String password = req.getParameter("password");
			String role = req.getParameter("role");
			
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setPhone(phone);
			emp.setPassword(password);
			emp.setRole(role);
			
			edao.updateEmployee(emp);
			
			resp.sendRedirect("view_all_emp");


			
	}
}
