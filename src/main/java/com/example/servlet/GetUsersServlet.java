package com.example.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.User;
import com.example.Warehouse;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    //write your code here!
  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

    Set<User> users = Warehouse.getInstance().getUsers();

    req.setAttribute("users", users);

    getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);

  }
}
