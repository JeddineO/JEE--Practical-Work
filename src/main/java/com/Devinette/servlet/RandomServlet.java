package com.Devinette.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/random")
public class RandomServlet extends HttpServlet {
    private static int random_number = 0;

    public void init() {
            Random rnd = new Random();
            random_number = rnd.nextInt(30) + 1;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action='random' method='POST'>");
        out.println("<p> Deviner (1-10) :  <input type='text' name='num'> </p>");
        out.println("<input type='submit'>");
        out.println("</form>");
        out.println("</body></html>");
        System.out.print(random_number);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        PrintWriter out = response.getWriter();
        if (num == random_number)
        {
            out.println("<script>alert('Bravo!');</script>");
            init();
        }
        else if (num > random_number)
            out.println("<script>alert('La valeur que vous avez entrée est supérieure!');</script>");
        else
            out.println("<script>alert('La valeur que vous avez entrée est inférieure!');</script>");
        doGet(request,response);
    }
  
}
