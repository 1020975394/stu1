package com.ziyou.servlet;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ziyou.domain.Student;
import com.ziyou.service.StudentService;
import com.ziyou.service.impl.StudentServiceImpl;



/**
 * 负责查询所有的学生信息然后呈现到页面上
 */
public class StudentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//查询出来所有的学生
			StudentService service=new StudentServiceImpl();
			List<Student> list=service.findAll();
			
			
			//2.先把数据存储到作用域
			request.setAttribute("list", list);
			
			//3.跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
