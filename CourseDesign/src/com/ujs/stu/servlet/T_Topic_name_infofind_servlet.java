package com.ujs.stu.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ujs.stu.dao.T_Topic_name_infodao;

/**
 * Servlet implementation class T_Topic_name_infofind_servlet
 */
@WebServlet("/T_Topic_name_infofind_servlet")
public class T_Topic_name_infofind_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_Topic_name_infofind_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		T_Topic_name_infodao F=new T_Topic_name_infodao();
		
		List<Map<String,String>> list =F.findAll();
		HttpSession session=request.getSession();
		session.setAttribute("Topic", list);
		response.sendRedirect("/CourseDesign/ujs/student/view_all.jsp");
	}

}
