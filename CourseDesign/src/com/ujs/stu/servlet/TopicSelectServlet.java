package com.ujs.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.ujs.man.dao.Teacher_InfoDao;

/**
 * Servlet implementation class TopicSelectServlet
 */
@WebServlet("/TopicSelectServlet")
public class TopicSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("tea1");
		String Topic = request.getParameter("Topic");
		HttpSession session = request.getSession();
		Map<String, String> map = (Map<String, String>) session.getAttribute("login_stu");

		String stu_group = map.get("stu_group");
		if(stu_group == null || stu_group.length() <= 0){
			response.setContentType("text/html;charset=utf-8");

			PrintWriter out=response.getWriter();

			out.print("<script language='javascript'>alert('请选好小组，再选课题。');window.location.href='/CourseDesign/MyGroup';</script>");
			return;
		}
		Teacher_InfoDao dao = new Teacher_InfoDao();
		List<Map<String, String>> list = dao.findteman(name);
		String tea_no = list.get(0).get("tea_no");

		Select_Course_InfoDao dao1 = new Select_Course_InfoDao();
		int row = dao1.insert(stu_group, tea_no, name, Topic);

		if (row > 0) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

}
