package com.ujs.tea.dao;

import java.util.List;
import java.util.Map;

import com.neu.dao.BaseDao;

public class T_Grade_Info extends BaseDao{

	public int insert(String no,String name,String topic_name,String grade)
	{
		int str = 0;
		String sql = "insert into t_grade_info(stu_no,stu_name,topic_name,grade) values(?,?,?,?)";
		str = super.executeUpdate(sql, no,name,topic_name,grade);
		return str;
	}
	
	public List<Map<String, String>> selectno(String no)
	{
		List<Map<String, String>> list = null;
		String sql = "select * from t_grade_info where stu_no=? ";
		list = super.executeQuery(sql,no);
		return list;
	}
}
