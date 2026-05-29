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


@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Email() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("email_.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String mobile = request.getParameter("mobile");
		String nickname = request.getParameter("nickname");
		String email= "";
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= null; PreparedStatement pstmt=null; ResultSet rset=null;
			PrintWriter out = response.getWriter();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root", "1234");
			pstmt = conn.prepareStatement("select email from users where mobile=? and nickname=?");
			pstmt.setString(1, mobile);
			pstmt.setString(2, nickname);
			
			rset = pstmt.executeQuery();
			if(rset.next())
			//{ out.print("해당 고객님의 이메일은 ["+rset.getString("email")+"] 입니다."); }
			{out.println("<script>alert('이메일: ["+rset.getString("email")+"] 입니다'); history.go(-1);</script>");}
			else{out.println("<script>alert('이메일찾기 오류'); history.go(-1);</script>");}
			
			if(rset!=null){rset.close();}
			if(pstmt!=null){pstmt.close();}
			if(conn!=null){conn.close();}
			
		}catch(Exception e){e.printStackTrace();}
		
	}

}
