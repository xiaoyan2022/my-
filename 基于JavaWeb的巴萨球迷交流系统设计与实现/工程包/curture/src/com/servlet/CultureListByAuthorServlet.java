package com.servlet;

import com.dao.CultureDao;
import com.model.Culture;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/cultureListByAuthor")
public class CultureListByAuthorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		try {
			List<Culture> cultures  = cultureDao.queryByAuthor(user.getUid());
			session.setAttribute("cu",cultures);
			req.getRequestDispatcher("cultureByAuthor.jsp").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
