package com.servlet;

import com.dao.CultureDao;
import com.model.Culture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cultureUpdateList")
public class CultureUpdateList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		int cno = Integer.parseInt(req.getParameter("cno"));
		try {
			Culture culture = cultureDao.queryByCno(cno);
			req.setAttribute("cul",culture);
			req.getRequestDispatcher("update_culture.jsp").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
