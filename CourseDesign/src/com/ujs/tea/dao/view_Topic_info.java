package com.ujs.tea.dao;
import java.util.List;
import java.util.Map;
import com.neu.dao.BaseDao;

public class view_Topic_info extends BaseDao{
	public  List<Map<String,String>> view_all_stu (String tname)
	{
		List<Map<String,String>> list=null;
		String sql="select * "
				+ " from t_select_course_info where sc_tea_name=?";
		list=super.executeQuery(sql ,tname);
		return list;
	}
}
