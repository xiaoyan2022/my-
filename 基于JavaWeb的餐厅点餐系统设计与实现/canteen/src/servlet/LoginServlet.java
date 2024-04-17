package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import serviceImpl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	int role = Integer.parseInt(request.getParameter("role"));
	String adminNum = request.getParameter("adminNum");
	String adminPwd = request.getParameter("adminPwd");
    HttpSession session = request.getSession();
	
    if(new UserServiceImpl().login(new User(adminNum,adminPwd))) {
    	String adName = new UserServiceImpl().queryByName(adminNum).getNickname();
        session.setAttribute("adName", adName);
        session.setAttribute("user", new UserServiceImpl().queryByName(adminNum));
        if(role==1) {
            request.getRequestDispatcher("/bookList").forward(request, response);
        }else {
            request.getRequestDispatcher("bookShow").forward(request, response);
        }
    }else {
    	session.setAttribute("msg", "用户名或密码错误");
    	request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
    }

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
