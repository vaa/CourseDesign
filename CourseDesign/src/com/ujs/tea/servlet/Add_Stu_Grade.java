package com.ujs.tea.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujs.tea.dao.Select_course_info;
import com.ujs.tea.dao.T_Grade_Info;

/**
 * Servlet implementation class Add_Stu_Grade
 */
@WebServlet("/Add_Stu_Grade")
public class Add_Stu_Grade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Stu_Grade() {
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
		request.setCharacterEncoding("UTF-8");
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String topic=request.getParameter("topic");
		String grade=request.getParameter("grade");
		
		T_Grade_Info dao=new T_Grade_Info();
		int row=0;
		row=dao.insert(no, name, topic, grade);
		if(row>0)
		{
			response.sendRedirect("/CourseDesign/ujs/teacher/group.jsp");
		}else
		{
			response.sendRedirect("fail.jsp");
		}
	}

}
