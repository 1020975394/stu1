package com.ziyou.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ziyou.dao.StudentDao;
import com.ziyou.domain.Student;
import com.ziyou.util.JDBCUtil02;
import com.ziyou.util.TextUtil;



/**
 * 这是Studentdao的实现，针对前面定义的规范，作出具体的实现
 * @author 梓游
 * 
 * */


public class StudentDaoImpl implements StudentDao {
	/**
	 * 查询所有学生
	 * */
	@Override
	public List<Student> findAll() throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
		
	}
	
	/**
	 * 插入学生
	 * */
	@Override
	public void insert(Student student) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("insert into stu values(null,?,?,?,?,?,?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHoby(),
				student.getInfo()
				);
		
	}
	
	
	/**
	 * 删除学生
	 * */
	@Override
	public void delete(int sid) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("delete from stu where sid=?",sid);
		
	}
	
	/**
	 * 查询单个学生
	 * */
	@Override
	public Student findStudentById(int sid) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class),sid);
		
	}
	
	/**
	 * 更新学生数据
	 * */
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("update stu set Sname=? , gender=? , phone=? , birthday=? , hoby=? , info=? where sid=?",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHoby(),
				student.getInfo(),
				student.getSid()
				);
	}
	
	/**
	 * 模糊查询数据
	 * */
	@Override
	public List<Student> SearchStudent(String sname,String gender) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		
		String sql="select * from stu where 1=1 ";
		List<String> list=new ArrayList<>();
		
		if(!TextUtil.isEmpty(sname)) {
			sql=sql+"and sname like ?";
			list.add("%"+sname+"%");
			
		}
		if(!TextUtil.isEmpty(gender)) {
			sql=sql+"and gender=?";
			list.add(gender);
		}
		
		return runner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		//第一个问号代表一页返回多少条记录，第二个问号代表跳过前面多少条数据
		//5--0---------第一页
		//5--5---------第二页
		//5--10---------第三页
		return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		
		//用于处理平均值，总的个数
		Long result=(long)runner.query("select count(*) from stu", new ScalarHandler());
		return result.intValue();
	}

	

}
