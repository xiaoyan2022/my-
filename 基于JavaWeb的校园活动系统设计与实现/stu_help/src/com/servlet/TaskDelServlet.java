package com.servlet;

import com.dao.TaskDao;
import com.model.Task;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/del_task")
public class TaskDelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int tid = Integer.parseInt(req.getParameter("tid"));
		TaskDao taskDao = new TaskDao();
		User user = (User)req.getSession().getAttribute("user");
		HttpSession session = req.getSession();
		try {
			taskDao.del(tid);
			session.setAttribute("count",taskDao.count(user.getSno(),1));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("taskListBySno?status=1").forward(req,resp);
	}
}
