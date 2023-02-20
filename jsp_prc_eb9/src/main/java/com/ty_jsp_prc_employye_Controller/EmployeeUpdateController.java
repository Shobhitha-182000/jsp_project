package com.ty_jsp_prc_employye_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty_jsp_prc_employye.Employee;
import com.ty_jsp_prc_employye_dao.EmployeeDao;

@WebServlet("/update")
public class EmployeeUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 
		 EmployeeDao employeeDao=new EmployeeDao();
		 Employee employee=employeeDao.getEmployeeById(id);
		 
		 if(employee!=null) {
			 HttpSession session=req.getSession();
			 String name=(String) session.getAttribute("employeename");
			 if(name!=null) {
				 req.setAttribute("employee", employee);
				 RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
				 dispatcher.forward(req, resp);
			 }
			 else {
				 req.setAttribute("message", "Login First");
				 RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				 dispatcher.forward(req, resp);
			 }
			 
			 
		 }
	}

}
