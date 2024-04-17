package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.User;
import serviceImpl.CartServiceImpl;

@WebServlet("/add_cart")
public class CartAddServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int bid = Integer.parseInt(request.getParameter("bid"));
	HttpSession session = request.getSession();
	User user = (User)session.getAttribute("user");
	Date date = new Date(System.currentTimeMillis());
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	
    new CartServiceImpl().add(new Cart(bid, user.getId(), 1, sqlDate));
    
    session.setAttribute("msg", "Ìí¼Ó³É¹¦");
    
    request.getRequestDispatcher("cartListByUid").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
