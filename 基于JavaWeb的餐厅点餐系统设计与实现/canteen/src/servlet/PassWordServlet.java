package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.UserDaoImpl;
import model.User;


@WebServlet("/update_password")
public class PassWordServlet extends HttpServlet{

private static final long serialVersionUID = -820852300256415161L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String pass = request.getParameter("new2");
	
	HttpSession session = request.getSession();
	
	User user = (User)session.getAttribute("user");
	
    new UserDaoImpl().password(new User(user.getId(),pass));
        
    session.setAttribute("msg", "修改密码成功，请重新登录");
    
    request.getRequestDispatcher("password.jsp").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
