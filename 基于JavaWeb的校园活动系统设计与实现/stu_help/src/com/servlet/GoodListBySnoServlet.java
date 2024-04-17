package com.servlet;

import com.dao.GoodDao;
import com.dao.TaskDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/goodListBySno")
public class GoodListBySnoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodDao goodDao = new GoodDao();
		HttpSession session = req.getSession();
		int status = Integer.parseInt(req.getParameter("status"));
		session.setAttribute("status",status);
		User user = (User)req.getSession().getAttribute("user");
		session.setAttribute("good",goodDao.queryAllBySno(user.getSno(),status));
		req.getRequestDispatcher("deal_user.jsp").forward(req,resp);
	}
}
