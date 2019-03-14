package com.ziyou.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ziyou.domain.Student;
import com.ziyou.service.StudentService;
import com.ziyou.service.impl.StudentServiceImpl;

/**
 * 
 * 这是根据单个学生的更新，查询一个学生
 * @author 梓游
 */
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//接收id
			int sid=Integer.parseInt(request.getParameter("sid"));
			
			//查询学生数据
			StudentService service=new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			//3.显示数据
			//存数据
			request.setAttribute("stu", stu);
			//跳转
			request.getRequestDispatcher("adit.jsp").forward(request, response);
			
			
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
