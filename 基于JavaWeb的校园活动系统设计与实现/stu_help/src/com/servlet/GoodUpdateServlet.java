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


@WebServlet("/update_good")
public class GoodUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodDao goodDao = new GoodDao();
		int gid = Integer.parseInt(req.getParameter("gid"));
		User user = (User)req.getSession().getAttribute("user");
		HttpSession session = req.getSession();
		try {
			goodDao.update(user.getSno(),gid);
			session.setAttribute("count4",goodDao.count(user.getSno(),0));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("goodListBySno?status=0").forward(req,resp);
	}
}
