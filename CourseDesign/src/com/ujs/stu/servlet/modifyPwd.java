package com.ujs.stu.servlet;

import java.io.IOException;
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
 * Servlet implementation class modifyPwd
 */
@WebServlet("/modifyPwd")
public class modifyPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String current_pwd = request.getParameter("current_pwd");
		String new_pwd = request.getParameter("new_pwd");
		
		HttpSession session = request.getSession();
		Map<String, String> map = (Map<String, String>) session.getAttribute("login_stu");
		String no = map.get("stu_no");
		
		StudentInfoDao dao =new StudentInfoDao();
		
		int row = 0;
		row = dao.updatePwd(no, new_pwd);
		if(row>0)
		{
			response.sendRedirect("success.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

}
