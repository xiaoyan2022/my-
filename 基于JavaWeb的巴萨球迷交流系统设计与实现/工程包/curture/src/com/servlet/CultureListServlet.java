package com.servlet;

import com.dao.CultureDao;
import com.model.Culture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/cultureList")
public class CultureListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		try {
			List<Culture> cultures  = cultureDao.query();
			HttpSession session = req.getSession();
			session.setAttribute("cultures",cultures);
			req.getRequestDispatcher("culture.jsp").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
