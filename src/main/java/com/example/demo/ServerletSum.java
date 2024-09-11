package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/servletsum")
public class ServerletSum extends HttpServlet {
    private int number1 = 0;
    private int number2 = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sum = number1 + number2;
        resp.getWriter().println("The sum of number1 and number2 is: " + sum);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String number1Str = req.getParameter("number1");
            String number2Str = req.getParameter("number2");

            number1 = Integer.parseInt(number1Str);
            number2 = Integer.parseInt(number2Str);

            resp.getWriter().println("Values updated: number1 = " + number1 + ", number2 = " + number2);

        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid input, please provide valid integers for 'number1' and 'number2'.");
        }
    }


    public void destroy() {
    }
}