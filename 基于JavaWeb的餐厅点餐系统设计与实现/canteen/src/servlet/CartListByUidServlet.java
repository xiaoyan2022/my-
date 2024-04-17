package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.CartDaoImpl;
import model.Cart;
import model.User;
import serviceImpl.CartServiceImpl;

@WebServlet("/cartListByUid")
public class CartListByUidServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		List<Cart> cartsById = new CartServiceImpl().queryByUid(user.getId());
		int total = new CartDaoImpl().total(user.getId());
		session.setAttribute("cartsById", cartsById);
		session.setAttribute("total", total);
		req.getRequestDispatcher("my_cart.jsp").forward(req, resp);
		
	}
}
