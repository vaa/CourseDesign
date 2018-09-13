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

import com.ujs.stu.dao.Group_Info;

/**
 * Servlet implementation class MyGroup
 */
@WebServlet("/MyGroup")
public class MyGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Map<String, String> map = (Map<String, String>) session.getAttribute("login_stu");
		String group = map.get("stu_group");
		if(group!=null && group.length()>0){
		Group_Info dao =new Group_Info();
		List<Map<String, String>> list = dao.findMember(group);
		session.setAttribute("MyGroup", list);
		}
		response.sendRedirect("/CourseDesign/ujs/student/MyGroup.jsp");
	}

}
