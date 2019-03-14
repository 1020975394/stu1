package com.ziyou.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ziyou.domain.Student;
import com.ziyou.service.StudentService;
import com.ziyou.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		try {
			//1.获取客户端提交上来的数据
			int sid=Integer.parseInt(request.getParameter("sid"));
			String sname=request.getParameter("sname");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("phone");
			String birthday=request.getParameter("birthday");
			//String hoby=request.getParameter("hoby");//拿值时只会拿一个
			
			String[] h=request.getParameterValues("hoby");
			String hoby=Arrays.toString(h).substring(1, Arrays.toString(h).length()-1);
			String info=request.getParameter("info");
			
			//2.添加到数据库
			//string--date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student=new Student(sname, gender, phone, hoby, info, date);
			student.setSid(sid);
			
			//更新数据库数据
			StudentService service=new StudentServiceImpl();
			service.update(student);
			
			
			//3.跳转到页面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
			
		} catch (Exception e) {
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
