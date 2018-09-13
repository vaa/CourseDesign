package com.ujs.man.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ujs.man.dao.StudentInfoDao;
import com.ujs.man.dao.Teacher_InfoDao;

/**
 * Servlet implementation class TeaSelectServlet
 */
@WebServlet("/TeaSelectServlet")
public class TeaSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaSelectServlet() {
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
		Teacher_InfoDao dao = new Teacher_InfoDao();
		List<Map<String, String>> list = dao.findall();
		HttpSession session = request.getSession();
		session.setAttribute("teas", list);
		response.sendRedirect("/CourseDesign/ujs/admin/teas.jsp");
	}

}
