package com.ziyou.service;

import java.sql.SQLException;
import java.util.List;

import com.ziyou.domain.PageBean;
import com.ziyou.domain.Student;

/**
 * 这是学生的业务处理规范
 * @author 梓游
 * */
public interface StudentService {
	
	
	/**
	 * 查询当页学生的数据
	 * @return List<Student>
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException;
	
	
	/**
	 * 查询所有学生
	 * @return List<Student>
	 * */
	
	List<Student> findAll() throws SQLException;
	
	/**
	 * 根据id查询单个学生对象
	 * @param sid 需要查询的数据库的学生对象的sid
	 * @return Student
	 * @throws SQLException
	 */
	Student findStudentById(int sid) throws SQLException;
	
	
	/**
	 * 根据条件模糊查询学生
	 * @return List<Student>
	 * @throws SQLException
	 */
	List<Student> SearchStudent(String sname,String gender) throws SQLException;
	
	/**
	 * 添加学生
	 * @param student 需要添加的数据库的学生对象
	 * */
	void insert(Student student) throws SQLException;
	
	/**
	 * 删除学生
	 * @param sid 需要删除的数据库的学生对象的sid
	 * */ 
	void delete(int sid) throws SQLException;
	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException;
}
