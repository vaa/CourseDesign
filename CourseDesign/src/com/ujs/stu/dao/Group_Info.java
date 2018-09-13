package com.ujs.stu.dao;

import java.util.List;
import java.util.Map;
import com.neu.dao.BaseDao;

public class Group_Info extends BaseDao{
	
	public List<Map<String,String>> findGroup(){
		List<Map<String,String>> list=null;
		String sql="select stu_group,count(*) as num from t_student_info group by stu_group order by stu_group desc";
		
		list = super.executeQuery(sql);
		
		return list;
	}
	
	public List<Map<String,String>> findMember(String group){
		List<Map<String,String>> list=null;
		String sql = "select stu_no,stu_name,stu_role from t_student_info where stu_group=?";
		list = super.executeQuery(sql,group);
		
		return list;
	}
}
