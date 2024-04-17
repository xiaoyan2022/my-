package com.servlet;

import com.dao.CultureDao;
import com.model.Culture;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add_num")
public class NumAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		int type = Integer.parseInt(req.getParameter("type"));
		int cno = Integer.parseInt(req.getParameter("cno"));
		CultureDao cultureDao = new CultureDao();
		try {
			cultureDao.updateNum(type,cno);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("cultureById?cno="+cno).forward(req,resp);
	}
}
