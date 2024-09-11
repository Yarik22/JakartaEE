package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/servletusers")
public class ServerletUsers extends HttpServlet {


    private static Map<Integer, String> users = new HashMap<>();

    public void init() throws ServletException {
        users.put(1, "Alice");
        users.put(2, "Bob");
        users.put(3, "Charlie");
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("id");

        if (userIdStr == null || userIdStr.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("User ID is required to delete a user.");
            return;
        }

        try {
            int userId = Integer.parseInt(userIdStr);

            if (users.containsKey(userId)) {
                String removedUser = users.remove(userId);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("User " + removedUser + " with ID " + userId + " was successfully deleted.");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().println("User with ID " + userId + " not found.");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Invalid user ID format. Please provide a numeric ID.");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Current users:");
        users.forEach((id, name) -> {
            try {
                resp.getWriter().println("ID: " + id + ", Name: " + name);
            } catch (IOException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        });
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        if (userName == null || userName.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("User name is required to add a new user.");
            return;
        }

        int newId = users.size() + 1;
        users.put(newId, userName);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().println("User " + userName + " added with ID " + newId);
    }
}