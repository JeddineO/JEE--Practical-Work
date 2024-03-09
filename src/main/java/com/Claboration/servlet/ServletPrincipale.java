package com.Claboration.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet-principale")
public class ServletPrincipale extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Integer compteur = (Integer) request.getAttribute("compteur");
        if (compteur == null) {
            compteur = 0;
            compteur++;
            request.setAttribute("compteur", compteur);

            out.println("<h1>Message n° " + compteur + " : Je suis dans la servlet principale</h1>");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet-secondaire");
            dispatcher.include(request, response);
        }else {
            compteur++;
            out.println("<h1>Message n° " + compteur + " : De retour dans la servlet principale</h1>");
        }


    }
}
