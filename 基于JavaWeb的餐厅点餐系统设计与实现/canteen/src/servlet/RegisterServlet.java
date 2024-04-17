package servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import serviceImpl.UserServiceImpl;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String adminNum = request.getParameter("adminNum");
	String adminPwd = request.getParameter("adminPwd");
	String nickname = UUID.randomUUID().toString().replace("-","").substring(0,6);
	new UserServiceImpl().register(new User(adminNum, adminPwd, "用户"+nickname));
	HttpSession session = request.getSession();
	session.setAttribute("msg", "注册成功");
    request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
