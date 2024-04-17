package com.servlet;

import com.dao.GoodDao;
import com.dao.TaskDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/goodDetailList")
public class GoodDetailListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodDao goodDao = new GoodDao();
		HttpSession session = req.getSession();
		int gid = Integer.parseInt(req.getParameter("gid"));
		session.setAttribute("d",goodDao.queryAllById(gid));
		req.getRequestDispatcher("detail_deal.jsp").forward(req,resp);
	}
}
