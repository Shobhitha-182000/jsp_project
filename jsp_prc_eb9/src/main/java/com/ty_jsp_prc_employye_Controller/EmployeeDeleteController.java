package com.ty_jsp_prc_employye_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty_jsp_prc_employye.Employee;
import com.ty_jsp_prc_employye_dao.EmployeeDao;

@WebServlet("/delete")
public class EmployeeDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 
		 EmployeeDao employeeDao=new EmployeeDao();
		 boolean result=employeeDao.deleteEmployee(id);
		 if (result) {
			List<Employee>list=employeeDao.getAll();
			req.setAttribute("list",list);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
			
		}
	}

}
