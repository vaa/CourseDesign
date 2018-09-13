package com.ujs.man.dao;

import java.util.List;
import java.util.Map;

import com.neu.dao.BaseDao;

public class Select_Course_InfoDao extends BaseDao {
	
	public int insert(String group,String tea_no,String tea_name,String Topic)
	{
		int str = 0;
		String sql = "insert into t_select_course_info(sc_group,sc_tea_no,sc_tea_name,sc_Topic_name) values(?,?,?,?)";
		str = super.executeUpdate(sql,group,tea_no,tea_name,Topic);
		return str;
	}
	
	public List<Map<String, String>> select(String group)
	{
		List<Map<String, String>> list = null;
		String sql = "select * from t_select_course_info where sc_group=?";
		list = super.executeQuery(sql,group);
		//sdsda
		return list;
	}
}
