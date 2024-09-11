package com.example.demo;

import java.io.*;
import java.lang.reflect.Array;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/servletopt")
public class ServerletOptions extends HttpServlet {
    String[] opts = {"GET","OPTIONS", "POST", "PUT", "DELETE"};

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Supported methods: " + String.join(", ", opts));
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Allow", String.join(", ", opts));
        resp.getWriter().println("Supported methods: " + String.join(", ", opts));
    }

    public void destroy() {
    }
}