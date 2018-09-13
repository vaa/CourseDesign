package com.ujs.stu.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
		    String name = req.getParameter("name");
		    
		    resp.setContentType("application/force-download");
		    String path = ("D:/upload/"+name);
		    InputStream in = new FileInputStream(path);
		    name = URLEncoder.encode(name, "UTF-8");
		    resp.setHeader("Content-Disposition", "attachment;filename="+name);   
		    resp.setContentLength(in.available());
		    
		    OutputStream out = resp.getOutputStream();
		    byte[] b = new byte[1024];
		    int len = 0;
		    while((len = in.read(b))!=-1){
		      out.write(b, 0, len);
		    }
		    out.flush();
		    out.close();
		    in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
