package com.the703.servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinAction() { super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join_servlet.jsp").forward(request,response); //회원가입 폼으로
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입기능
		//1. 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		//2. sql 처리
		Connection conn = null; PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdbig","root","1234");
			pstmt=conn.prepareStatement("insert into users(nickname,bpass,email,mobile,bip) values(?,?,?,?,?)");
			
			pstmt.setString(1,nickname);
			pstmt.setString(2,bpass);
			pstmt.setString(3,email);
			pstmt.setString(4,mobile);
			pstmt.setString(5,InetAddress.getLocalHost().getHostAddress());
			
			//3. 해당처리화면 - 로그인 폼으로 (LoginAction-Get)
			if(pstmt.executeUpdate()>0){
				out.println("<script>alert('회원가입성공');location.href='LoginAction';</script>");
				}
			else {
				out.println("<script>alert('회원가입실패'); history.go(-1);</script>");
					}
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			
			
		}catch(Exception e) {e.printStackTrace();}
			
	}

}
