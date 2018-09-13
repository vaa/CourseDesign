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

import com.ujs.man.dao.StudentInfoDao;

/**
 * Servlet implementation class MemberSubmit
 */
@WebServlet("/MemberSubmit")
public class MemberSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSubmit() {
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
		String stu_no = request.getParameter("stu_no");
		String group = request.getParameter("group");
		String role = request.getParameter("role");
		System.out.println("stu_no:"+stu_no+"group:"+group +"role:"+role);
		StudentInfoDao dao = new StudentInfoDao();
		int row = 0;
		row = dao.updateGroup(stu_no,group,role);
		if(role.equals("组长")){
			List<Map<String, String>> list_stu = dao.selectno(stu_no);
			HttpSession session = request.getSession();
			session.setAttribute("login_stu",list_stu.get(0));
		}
		if(row>0)
		{
			response.sendRedirect("/CourseDesign/MyGroup");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

}
