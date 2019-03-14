package com.ziyou.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ziyou.domain.PageBean;
import com.ziyou.service.StudentService;
import com.ziyou.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListPageServlet
 */
public class StudentListPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//1.获取显示的页码数
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			
			//2.根据指定的页数，获取该页的数据回来
			StudentService service=new StudentServiceImpl();
			PageBean pageBean = service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			
			//3.跳转页面
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
