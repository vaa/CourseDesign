package com.ujs.tea.dao;


import com.neu.dao.BaseDao;
import java.util.List;
import java.util.Map;



public class Select_course_info extends BaseDao {
	
	public int save(String sname,String sno,String tname,String tno,String ename){
		int row=0;
		String sql="insert into t_select_course_info(sc_stu_name,sc_stu_no,sc_tea_name,sc_tea_no,sc_Topic_name)"
				+ " values(?,?,?,?,?)";
		row=super.executeUpdate(sql,sname,sno,tname,tno,ename);
		return row;
	}
	public int dele(String sname){
		int row=0;
		String sql="delete from t_select_course_info where sc_stu_name=?";
		row=super.executeUpdate(sql, sname);
		return row;
	}
	
	public int update (String name1,String no,String date){
		int row=0;
		String sql="UPDATE t_select_course_info SET topic_date=? WHERE sc_topic_name=? and sc_group=?";
		row=super.executeUpdate(sql,date,name1,no);
		return row;
	}
	public int updateTopic(String group,String Topicname,String filename)
	{
		int str = 0;
		String sql = "UPDATE t_select_course_info SET topic_date=CURRENT_TIMESTAMP(), filename=? WHERE sc_topic_name=? and sc_group=?";
		str = super.executeUpdate(sql,filename,Topicname,group);
		return str;
	}
	
	public List<Map<String, String>> findE_flag(String ename)
	{
		List<Map<String,String>> list=null;
		String sql="select * from t_select_course_info where sc_Topic_name=?";
		list=super.executeQuery(sql,ename);
		return list;
		
	}
	
	public List<Map<String, String>> stu_findAll(String tname)
	{
		List<Map<String,String>> list=null;
		String sql="select sc_stu_no,sc_stu_name,sc_Topic_name from t_select_course_info where sc_tea_name=? ";
		list=super.executeQuery(sql,tname);
		return list;
		
	}


}