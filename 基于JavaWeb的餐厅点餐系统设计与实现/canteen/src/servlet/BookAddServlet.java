package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Book;
import serviceImpl.BookServiceImpl;

@WebServlet("/add_book")
@MultipartConfig()
public class BookAddServlet extends HttpServlet{

private static final long serialVersionUID = -820852300256415161L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	Part part=request.getPart("myfile"); //ͨ�����е�name���Ի�ȡ�����е��ļ�
    part.write("D:\\canteen\\WebContent\\upload\\"+part.getSubmittedFileName());//���ļ��ƶ����ض��Ĵ���·��
//    part.write("D:\\imgs\\"+part.getSubmittedFileName());//���ļ��ƶ����ض��Ĵ���·��
    String fname=part.getSubmittedFileName();
    String name = request.getParameter("name");
    String author = request.getParameter("author");
    String publish = request.getParameter("publish");
    Float price = Float.valueOf(request.getParameter("price"));

    new BookServiceImpl().add(new Book(name, author, fname, publish, price));
    
    HttpSession session = request.getSession();
    session.setAttribute("msg", "��ӳɹ�");
    
    request.getRequestDispatcher("bookList").forward(request, response);
	}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
