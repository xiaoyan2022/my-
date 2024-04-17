package servlet;

import java.io.IOException;
import java.sql.Date;
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
import dao.UserDao;
import javafx.scene.layout.Background;
import model.Blog;
import model.User;


@WebServlet("/blog_update")
public class BlogUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String type = req.getParameter("type");
		try {
			if(new BlogDao().updateBlog(new Blog(id, title, content, type, new java.util.Date()))) {
				req.getRequestDispatcher("blogList2").forward(req, resp);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
