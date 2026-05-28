package com.the703.servlet;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jsp019
 */
@WebServlet("/MilkInsert")
public class jsp019 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsp019() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String oname =request.getParameter("oname");
		int onum =Integer.parseInt(request.getParameter("onum"));
		System.out.println("...."+oname + "/" +onum);
		
		//2. sql 처리
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			ConnectException conn=null; PreparedStatement pstmt=null;
//			conn = (ConnectException) DriverManager.getConnection("sql", "root", "1234");
//			
//			
//		}catch(Exception e) {e.printStackTrace();}
		
		//3. 처리결과 + 경로 > jsp019_index.jsp
		response.sendRedirect("jsp019_index.jsp?oname="+oname);
	}

}
