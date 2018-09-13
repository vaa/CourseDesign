package com.ujs.tea.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ujs.stu.dao.Group_Info;

/**
 * Servlet implementation class Find_Group_Stu
 */
@WebServlet("/Find_Group_Stu")
public class Find_Group_Stu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_Group_Stu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String group=request.getParameter("sc_group");
		String topic_name=request.getParameter("sc_topic_name");
		
		Group_Info dao =new Group_Info();
		List<Map<String, String>> list = dao.findMember(group);

		session.setAttribute("Group", list);
		session.setAttribute("topic_name", topic_name);
		
		response.sendRedirect("/CourseDesign/ujs/teacher/group.jsp");
	}

}
