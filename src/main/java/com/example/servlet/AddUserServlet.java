package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.User;
import com.example.Warehouse;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

    getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
  }

  @Override protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    User user = new User(req.getParameter("firstName"), req.getParameter("lastName"));

    Warehouse warehouse = Warehouse.getInstance();
    warehouse.addUser(user);
    req.setAttribute("user", user);
    getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
  }
}
