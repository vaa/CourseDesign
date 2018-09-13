package com.ujs.man.dao;

import java.util.List;
import java.util.Map;

import com.neu.dao.BaseDao;

public class StudentInfoDao extends BaseDao {
		
	public int insert(String no,String name,String pwd)
	{
		int str = 0;
		String sql = "insert into t_student_info(stu_no,stu_name,stu_pwd) values(?,?,?)";
		str = super.executeUpdate(sql, no,name,pwd);
		return str;
	}
	public int update(String no,String name,String pwd)
	{
		int str = 0;
		String sql = "UPDATE t_student_info SET stu_no=?,stu_name=?,stu_pwd = ? WHERE stu_no = ?";
		str = super.executeUpdate(sql, no,name,pwd,no);
		return str;
	}
	
	public int updatePwd(String no,String pwd)
	{
		int str = 0;
		String sql = "UPDATE t_student_info SET stu_pwd=? where stu_no=?";
		str = super.executeUpdate(sql, pwd,no);
		return str;
	}
	
	public int updateGroup(String no,String group,String role)
	{
		int str = 0;
		String sql = "UPDATE t_student_info SET stu_group=?,stu_role=? where stu_no=?";
		str = super.executeUpdate(sql,group,role,no);
		return str;
	}
	
	public int clearGroup(String group)
	{
		int str = 0;
		String sql = "UPDATE t_student_info SET stu_group=?,stu_role=? where stu_group=?";
		str = super.executeUpdate(sql,group,"",group);
		return str;
	}
	
	public int delete(String no)
	{
		int str = 0;
		String sql = "delete from t_student_info where stu_no = ?";
		str = super.executeUpdate(sql, no);
		return str;
	}
	public List<Map<String, String>> select()
	{
		List<Map<String, String>> list = null;
		String sql = "select * from t_student_info";
		list = super.executeQuery(sql);
		return list;
	}
	public List<Map<String, String>> selectno(String no)
	{
		List<Map<String, String>> list = null;
		String sql = "select * from t_student_info where stu_no=?";
		list = super.executeQuery(sql,no);
		return list;
	}
	public List<Map<String, String>> checkLogin(String no,String pwd)
	{
		List<Map<String, String>> list = null;
		String sql = "select * from t_student_info where stu_no=? and stu_pwd = ? ";
		list = super.executeQuery(sql,no,pwd);
		return list;
	}
	
	public List<Map<String, String>> findall()
	{
		List<Map<String, String>> list = null;
		String sql="select *from t_student_info";
		list = super.executeQuery(sql);
		return list;
	}
}
