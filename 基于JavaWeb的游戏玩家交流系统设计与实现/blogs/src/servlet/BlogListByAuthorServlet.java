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
import model.User;

@WebServlet("/blogListByAuthor")
public class BlogListByAuthorServlet extends HttpServlet{

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
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		try {
			blogs =  blogDao.queryAllByAuthor(user.getId());
			session.setAttribute("blogById",blogs);
			req.getRequestDispatcher("blog_author.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
