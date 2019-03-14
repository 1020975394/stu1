package com.ziyou.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ziyou.domain.Student;
import com.ziyou.service.StudentService;
import com.ziyou.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			
			String sname=request.getParameter("sname");
			String gender=request.getParameter("sgender");
			
			//查询出来所有的学生
			StudentService service=new StudentServiceImpl();
			List<Student> list=service.SearchStudent(sname, gender);
			
			
			//2.先把数据存储到作用域
			request.setAttribute("list", list);
			
			//3.跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			
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
