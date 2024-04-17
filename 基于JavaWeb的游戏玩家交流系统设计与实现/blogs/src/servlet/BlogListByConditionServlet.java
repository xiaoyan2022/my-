package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BlogDao;
import model.Blog;

@WebServlet("/blogListByCondition")
public class BlogListByConditionServlet extends HttpServlet{

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
		BlogDao blogDao = new BlogDao();
		List<Blog> blogs = new ArrayList<Blog>();
		String title = req.getParameter("title");
		String type = req.getParameter("type");
		try {
			blogs =  blogDao.queryAllByCondition(title,type);
			HttpSession session = req.getSession();
			session.setAttribute("blogList",blogs);
			req.getRequestDispatcher("blog.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
