package com.ty_jsp_prc_employye_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty_jsp_prc_employye.Employee;
import com.ty_jsp_prc_employye_dao.EmployeeDao;



@WebServlet("/signup")
public class EmployeeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address =req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employee2=employeeDao.savEmployee(employee);
		
		if(employee2!=null) {
			req.setAttribute("message", "Sign up successfully");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
			
		}
		 
	}

}
