package com.ujs.stu.dao;

import java.util.List;
import java.util.Map;

import com.neu.dao.BaseDao;

public class T_Topic_name_infodao extends BaseDao {
	
	public List<Map<String,String>> findAll(){
		List<Map<String,String>> list=null;
		String sql="select * from t_Topic_name_info";
		
		list = super.executeQuery(sql);
		
		return list;
	}
	

}
