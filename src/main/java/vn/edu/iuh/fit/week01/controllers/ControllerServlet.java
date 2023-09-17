package vn.edu.iuh.fit.week01.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.repositories.AccountRepository;

import java.io.IOException;

@WebServlet(urlPatterns = {"/ControllerServlet","/control"})
public class ControllerServlet  extends HttpServlet {
    private  AccountRepository accountRepository = new AccountRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountRepository.login(username, password);
        RequestDispatcher request;
        if (account!=null) {
            // Set the "username" and "password" as request attributes
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            request = req.getRequestDispatcher("dashboard.html");
        } else {
            // Handle the case when login fails
            request = req.getRequestDispatcher("user.html");
        }
        request.forward(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
