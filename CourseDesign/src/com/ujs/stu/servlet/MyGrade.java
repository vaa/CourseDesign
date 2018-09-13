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

import com.ujs.man.dao.Select_Course_InfoDao;
import com.ujs.man.dao.StudentInfoDao;
import com.ujs.tea.dao.T_Grade_Info;

/**
 * Servlet implementation class MyGrade
 */
@WebServlet("/MyGrade")
public class MyGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGrade() {
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
		
		T_Grade_Info dao = new T_Grade_Info();
		List<Map<String, String>> list = dao.selectno(no);
		session.setAttribute("MyGrade", list);
		
		response.sendRedirect("/CourseDesign/ujs/student/MyGrade.jsp");
	}

}
