package com.the703.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jsp019_2
 */
@WebServlet("/JoinAction")
public class jsp019_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsp019_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charest=UTF-8");
		
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
	//	response.sendRedirect("jsp019_result.jsp?nickname="+nickname +"&email="+email +"&mobile="+mobile);
		request.setAttribute("nickname", nickname);
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		request.getRequestDispatcher("jsp019_result.jsp").forward(request, response);

	}

}
