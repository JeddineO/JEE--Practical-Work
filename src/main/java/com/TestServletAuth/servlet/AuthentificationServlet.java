package com.TestServletAuth.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthentificationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    response.setContentType("text/html");

	    PrintWriter out = response.getWriter();
	    out.println("<html><body>");
	    out.println("<form action='welcome' method='POST'>"); 
	    out.println("Nom : <input type='text' name='nom'/>"); 
	    out.println("Prenom : <input type='text' name='prenom'/>"); 
	    out.println(" <input type='submit'/>");
	    out.println("</form>");
	    out.println("</body></html>");
	}

    


}
