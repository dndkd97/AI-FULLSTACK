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


@WebServlet("/Pass")
public class Pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Pass() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pass_.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String bpass= "";
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= null; PreparedStatement pstmt=null; ResultSet rset=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root", "1234");
			pstmt = conn.prepareStatement("select bpass from users where mobile=? and email=?");
			pstmt.setString(1, mobile);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			if(rset.next())
			//{ out.print("해당 고객님의 이메일은 ["+rset.getString("email")+"] 입니다."); }
			{out.println("<script>alert('비밀번호: ["+rset.getString("bpass")+"] 입니다'); history.go(-1);</script>");}
			else{out.println("<script>alert('비밀번호찾기 오류'); history.go(-1);</script>");}
			
			if(rset!=null){rset.close();}
			if(pstmt!=null){pstmt.close();}
			if(conn!=null){conn.close();}
			
		}catch(Exception e){e.printStackTrace();}
	}

}
