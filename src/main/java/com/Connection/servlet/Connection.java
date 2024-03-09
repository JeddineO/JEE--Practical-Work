package com.Connection.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/connect")
public class Connection extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Integer compteur = (Integer) session.getAttribute("compteur");

        if (compteur == null)
            compteur = 0;

        compteur++;
        session.setAttribute("compteur", compteur);
        out.println("<h1>Vous êtes connecté " + compteur + " fois</h1>");
    }
    
   
}
