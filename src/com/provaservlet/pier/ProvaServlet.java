package com.provaservlet.pier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

/**
 * Servlet implementation class ProvaServlet
 */
@WebServlet("/ProvaServlet")
public class ProvaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String nome = request.getParameter("nome");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		
		PrintWriter writer = response.getWriter();
		
		if(nome != null && !nome.isEmpty() && password!=null && !password.isEmpty()){
			writer.println("Benvenuto " + nome +"!\n");
			session.setAttribute("nomeAttuale", nome);
			writer.println("Session: " + session.getAttribute("nomeAttuale"));
		} else {
			response.sendRedirect("login.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		PrintWriter writer = response.getWriter();
		
		if (nome != null && !nome.isEmpty() && password != null && !password.isEmpty()){
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
