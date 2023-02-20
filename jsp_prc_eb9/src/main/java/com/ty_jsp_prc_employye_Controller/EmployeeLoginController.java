package com.ty_jsp_prc_employye_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty_jsp_prc_employye.Employee;
import com.ty_jsp_prc_employye_dao.EmployeeDao;

@WebServlet("/login")
public class EmployeeLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String email=req.getParameter("email");
		 String password=req.getParameter("password");
		 
		 Employee employee=new Employee();
		 employee.setEmail(email);
		 employee.setPassword(password);
		 
		 EmployeeDao employeeDao=new EmployeeDao();
		 Employee employee2 = employeeDao.getEmployyebyemail(email);
		 
		 if(employee2.getPassword().equals(password)) {
			 List<Employee> list=employeeDao.getAll();
			 req.setAttribute("list", list);
			 //cookies
//			 Cookie cookie=new Cookie("name", employee2.getName());
//			 resp.addCookie(cookie);
			 
			 HttpSession session=req.getSession();
			 session.setAttribute("employeename",employee2.getName());
			 
			 RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			 dispatcher.forward(req, resp);
		 }
		 else {
			 req.setAttribute("message", "invalid password");
			 RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			 dispatcher.include(req, resp);
		 }
	}

}
