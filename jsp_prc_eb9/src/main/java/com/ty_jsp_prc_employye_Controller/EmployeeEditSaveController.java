package com.ty_jsp_prc_employye_Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty_jsp_prc_employye.Employee;
import com.ty_jsp_prc_employye_dao.EmployeeDao;

@WebServlet("/edit")
public class EmployeeEditSaveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);

		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee2 = employeeDao.updateEmployee(employee);

		if (employee2 != null) {
			List<Employee> list = employeeDao.getAll();
			req.setAttribute("list", list);
			// cookies to print on browser
			Cookie[] cookies = req.getCookies();
			String value = null;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")){
					value = cookie.getValue();
				}
			}
			req.setAttribute("value", value);
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
