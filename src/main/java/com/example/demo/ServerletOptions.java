package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/servletoper")
public class ServerletOperations extends HttpServlet {
    private int number1 = 0;
    private int number2 = 0;
    private String operation = "";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        try {
            switch (operation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        resp.getWriter().println("Cannot divide by zero");
                        return;
                    }
                    break;
                default:
                    resp.getWriter().println("Invalid operation. Please use one of the following: +, -, *, /");
                    return;
            }

            resp.getWriter().println("Result of " + number1 + " " + operation + " " + number2 + " is: " + result);
        } catch (Exception e) {
            resp.getWriter().println("Error processing the request.");
        }
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Allow", "GET, OPTIONS");
        
        resp.getWriter().println("Supported methods: GET, OPTIONS");
    }

    public void destroy() {
    }
}