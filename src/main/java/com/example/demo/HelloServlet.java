package com.example.demo;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello User!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<div style='padding: 20px; border: 1px solid #ddd; border-radius: 5px;'>");
        out.println("<h1 style='color: #333; font-family: Arial, sans-serif;'>" + message + "</h1>");
        out.println("<p style='font-size: 16px; color: #666;'>Welcome to the Jakarta EE Servlet!</p>");
        String name = request.getParameter("name");
        if (name != null && !name.isEmpty()) {
            out.println("<p style='font-size: 16px; color: #333;'>Hello, " + name + "!</p>");
        }

        out.println("<a href='index.jsp' style='color: #007bff; text-decoration: none;'>Go back to Home</a>");
        out.println("</div>");
    }


    public void destroy() {
    }
}