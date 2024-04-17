package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serviceImpl.BookServiceImpl;

@WebServlet("/bookListById")
public class BookListByIdServlet extends HttpServlet{

private static final long serialVersionUID = -820852300256415161L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));

    request.setAttribute("book", new BookServiceImpl().queryAllById(id));
    
    request.getRequestDispatcher("update_book.jsp").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
