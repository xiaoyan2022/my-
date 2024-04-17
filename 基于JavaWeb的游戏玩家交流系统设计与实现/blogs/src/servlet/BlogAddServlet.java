package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BlogDao;
import model.Blog;
import model.User;

@WebServlet("/blog_add")
public class BlogAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String type = req.getParameter("type");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		BlogDao blogDao = new BlogDao();
		try {
			blogDao.addBlog(new Blog(user.getId(), title, content, type, new Date(), new Date()));
			req.getRequestDispatcher("blogList").forward(req, resp);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
