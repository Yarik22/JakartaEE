package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletoper")
public class ServerletOper extends HttpServlet {

    private static double number1 = 0;
    private static double number2 = 0;
    private static String operation = "add";

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1Str = req.getParameter("number1");
        String num2Str = req.getParameter("number2");
        String op = req.getParameter("operation");
        try {
            if (num1Str != null && !num1Str.isEmpty()) {
                number1 = Double.parseDouble(num1Str);
            }
            if (num2Str != null && !num2Str.isEmpty()) {
                number2 = Double.parseDouble(num2Str);
            }

            if (op != null && !op.isEmpty()) {
                if (op.equals("add") || op.equals("subtract") || op.equals("multiply") || op.equals("divide")) {
                    operation = op;
                } else {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    resp.getWriter().println("Invalid operation. Valid operations are: add, subtract, multiply, divide.");
                    return;
                }
            }

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Operation and numbers updated successfully.");

        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Invalid number format. Please provide numeric values.");
        }
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double result;

        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 == 0) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    resp.getWriter().println("Cannot divide by zero.");
                    return;
                }
                result = number1 / number2;
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().println("Unexpected operation.");
                return;
        }

        resp.setContentType("text/plain");
        resp.getWriter().println("Operation: " + operation);
        resp.getWriter().println("Number 1: " + number1);
        resp.getWriter().println("Number 2: " + number2);
        resp.getWriter().println("Result: " + result);
    }


    public void destroy() {
    }
}