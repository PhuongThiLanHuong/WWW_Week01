package vn.edu.iuh.fit.week01.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import vn.edu.iuh.fit.week01.entities.Account;
import vn.edu.iuh.fit.week01.repositories.AccountRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/ControllerServlet","/control"})
public class ControllerServlet  extends HttpServlet {
    private  AccountRepository accountRepository = new AccountRepository();
    private Logger logger;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        if ("Login".equals(action)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Account account = accountRepository.login(username, password);
            RequestDispatcher request;
            if (account!=null) {
                // Set the "username" and "password" as request attributes
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("account", account);
                request = req.getRequestDispatcher("dashboard.jsp");
            } else {
                request = req.getRequestDispatcher("error.jsp");
            }
            request.forward(req, resp);
        } else if ("addAccount".equals(action)) {
            String account_id = req.getParameter("account_id");
            String full_name = req.getParameter("full_name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Short status = Short.valueOf(req.getParameter("status"));

            Account account = new Account(account_id, full_name, password, email, phone, status);

            try {
                accountRepository.createAccount(account);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("dashboard.jsp");
        }else if ("deleteAccount".equals(action)) {
            String updateUsername = req.getParameter("deleteUsername");
            Optional<Account> a = null;
            try {
                a = accountRepository.getById(updateUsername);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (a == null) {
                resp.sendRedirect("error.jsp");
            }
            try {
                accountRepository.deleteAccount(updateUsername);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else if("updateAccount".equals(action)){
            String account_id = req.getParameter("account_id");
            String full_name = req.getParameter("full_name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Short status = Short.valueOf(req.getParameter("status"));

            Account account = new Account(account_id, full_name, password, email, phone, status);

            try {
                accountRepository.updateAccount(account);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect("dashboard.jsp");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            accountRepository.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        dispatcher.forward(req, resp);
    }
}
