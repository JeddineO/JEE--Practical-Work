package com.Claboration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet-secondaire")
public class ServletSecondaire extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Integer compteur = (Integer) request.getAttribute("compteur");
        if(compteur != null)
        {
        	 compteur++;
        	 out.println("<h1>Message n° " + compteur + " : Je suis dans la servlet secondaire</h1>");
             request.setAttribute("compteur", compteur);
             RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet-principale");
             dispatcher.include(request, response);
            
        }else
        {
       	 out.println("<h1>Message n° 1 : Je suis dans la servlet secondaire</h1>");

        }
       
       
    }
}
