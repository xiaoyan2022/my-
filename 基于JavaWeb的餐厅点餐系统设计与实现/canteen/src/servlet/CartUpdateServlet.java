package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.CartDaoImpl;
import serviceImpl.CartServiceImpl;

@WebServlet("/update_cart")
public class CartUpdateServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int id = Integer.parseInt(request.getParameter("id"));
	int add = Integer.parseInt(request.getParameter("add"));
	
	if(add!=1 & new CartDaoImpl().getNumById(id)==1) {
		new CartDaoImpl().del(id);
	    request.getRequestDispatcher("cartListByUid").forward(request, response);
	}else {
		new CartServiceImpl().update(add==1,id);
	    request.getRequestDispatcher("cartListByUid").forward(request, response);
		
	}
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
