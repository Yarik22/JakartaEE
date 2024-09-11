package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/servletGet")
public class ServerletGet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    public void destroy() {
    }
}