package com.TestServletDate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();        
        System.out.println("Initialisation de la servlet DateServlet");
    }

    @Override
    public void destroy() {
        System.out.println("Suppression de la servlet DateServlet");
        super.destroy();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Date currentDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(currentDate);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Date : " + formattedDate + "</h1>");
        out.println("</body></html>");
    }
}
