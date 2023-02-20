package com.ty_jsp_prc_mcdonalds_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty_jsp_prc_mcdonalds_dao.ItemsDao;
import com.ty_jsp_prc_mcdonalds_dto.Items;

 
@WebServlet("/confirm")
public class ConfirmMenuController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		long price = Long.parseLong(req.getParameter("price"));
		String offer = req.getParameter("offer");
		long quantity=Long.parseLong(req.getParameter("quantity"));
		
		Items items=new Items();
		items.setName(name);
		items.setDescription(description);
		items.setPrice(price);
		items.setOffer(offer);
		items.setQuantity(quantity);
		
		ItemsDao dao=new ItemsDao();
		Items items2=dao.saveItems(items);
		
	}

}
