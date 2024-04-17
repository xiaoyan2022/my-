package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.CartDaoImpl;


@WebServlet("/del_cart")
public class CartDelServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int id = Integer.parseInt(request.getParameter("id"));
	
    new CartDaoImpl().del(id);
    
    request.getRequestDispatcher("cartListByUid").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
