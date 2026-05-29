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


@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyAction() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String email = (String) session.getAttribute("email");
	//	if(email==null) {out.println("<script>alert('로그인 정보가 없습니다'); location.href='index.jsp';</script>");}
		String nickname ="";
		String mobile ="";
		String udate = "";
		String bip ="";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null; PreparedStatement pstmt = null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
			ResultSet rset = null;
			
			pstmt=conn.prepareStatement("select * from users where email=?");
			
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if(rset.next()){
			    nickname = rset.getString("nickname");
			    email = rset.getString("email");
			    mobile = rset.getString("mobile");
			    udate = rset.getString("udate");
			    bip = rset.getString("bip");
				
				request.setAttribute("nickname", nickname); 
				request.setAttribute("email", email); 
				request.setAttribute("mobile", mobile); 
				request.setAttribute("udate", udate); 
				request.setAttribute("bip", bip); 
				
				request.getRequestDispatcher("mypage_servlet.jsp").forward(request, response);
			}
			
			if(rset!=null) {rset.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		}catch(Exception e){e.printStackTrace();}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
