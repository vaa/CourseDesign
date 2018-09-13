package com.ujs.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujs.tea.dao.Select_course_info;

/**
 * Servlet implementation class AddTopicInfo
 */
@WebServlet("/AddTopicInfo")
public class AddTopicInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name1=request.getParameter("Topic_name");
		String no=request.getParameter("e_stu_group");
		String date=request.getParameter("Topic_date");
		Select_course_info F=new Select_course_info();
		int row=F.update(name1, no, date);
		if(row>0)
		{
			response.sendRedirect("success.jsp");
		}else{
			response.sendRedirect("fail.jsp");
		}
		
	}

}
