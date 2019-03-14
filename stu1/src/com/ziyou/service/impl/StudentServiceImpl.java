package com.ziyou.service.impl;

import java.sql.SQLException;
import java.util.List;


import com.ziyou.dao.StudentDao;
import com.ziyou.dao.impl.StudentDaoImpl;
import com.ziyou.domain.PageBean;
import com.ziyou.domain.Student;
import com.ziyou.service.StudentService;


/**
 * 这是学生业务实现
 * @author 梓游
 *
 */


public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {

		StudentDao dao=new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {

		StudentDao dao=new StudentDaoImpl();
		dao.insert(student);
		
	}

	@Override
	public void delete(int sid) throws SQLException {

		StudentDao dao=new StudentDaoImpl();
		dao.delete(sid);
		
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {

		StudentDao dao=new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		
		StudentDao dao=new StudentDaoImpl();
		dao.update(student);
		
	}

	@Override
	public List<Student> SearchStudent(String sname, String gender) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.SearchStudent(sname, gender);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		// 封装分页的该页数据
		PageBean<Student> pagebean=new PageBean<Student>();
		
		int pageSize=StudentDao.PAGE_SIZE;
		pagebean.setCurrentPage(currentPage);//设置当前页
		pagebean.setPageSize(StudentDao.PAGE_SIZE);//设置每页显示多少记录
		
		StudentDao dao=new StudentDaoImpl();
		List<Student> list=new StudentDaoImpl().findStudentByPage(currentPage);
		pagebean.setList(list);//设置每一页的学生数据
		
		//总的记录数，总的页数
		int count=dao.findCount();
		pagebean.setTotalSize(count);//设置总的记录数
		pagebean.setTotalPage(count % pageSize==0?count/pageSize:(count/pageSize)+1);
		
		return pagebean;
	}

}
