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
import javax.websocket.Session;

import com.ujs.man.dao.Select_Course_InfoDao;
import com.ujs.man.dao.StudentInfoDao;

/**
 * Servlet implementation class MyTopicServlet
 */
@WebServlet("/MyTopicServlet")
public class MyTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTopicServlet() {
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
		HttpSession session = request.getSession();
		Map<String, String> map = (Map<String, String>) session.getAttribute("login_stu");
		String no = map.get("stu_no");
		String group = map.get("stu_group");
		
		Select_Course_InfoDao dao =new Select_Course_InfoDao();
		List<Map<String, String>> list = dao.select(group);
		
		StudentInfoDao dao1 = new StudentInfoDao();
		List<Map<String, String>> list1 = dao1.selectno(no);
		session.setAttribute("Mystudent", list1.get(0));
		session.setAttribute("MyTopic", list);
		
		response.sendRedirect("/CourseDesign/ujs/student/MyTopic.jsp");
	}

}
