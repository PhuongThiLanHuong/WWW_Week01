package vn.edu.iuh.fit.week01.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.repositories.AccountRepository;
import vn.edu.iuh.fit.week01.services.AccountServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/ControllerServlet","/control"})
public class ControllerServlet  extends HttpServlet {
   private  AccountRepository accountRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        RequestDispatcher request;
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
                Account account = accountRepository.logIn(username, password);
            if (account!=null) {
                // Set the "username" and "password" as request attributes
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                request = req.getRequestDispatcher("dashboard.html");
            } else {
                // Handle the case when login fails
                request = req.getRequestDispatcher("er.html");
            }
            request.forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
