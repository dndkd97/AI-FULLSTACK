package com.the703.servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginAction() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login_servlet.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String bpass = request.getParameter("bpass");
		Connection conn= null; PreparedStatement pstmt = null; ResultSet rset=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
			pstmt=conn.prepareStatement("select * from users where email=? and bpass=?");
		    pstmt.setString(1, email);
		    pstmt.setString(2, bpass);
				
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				out.println("<script>alert('로그인성공'); location.href='MyAction';</script>");
				HttpSession session = request.getSession();
				session.setAttribute("email", email); 
				session.setMaxInactiveInterval(60 * 60);

			}
			else {
				out.println("<script>alert('로그인실패'); histroy.go(-1);</script>");
			}
			
			
			
			if(rset!=null) {rset.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
