package com.tw.servlet.learn;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hello",
        urlPatterns = {"/hello"},
        initParams = {@WebInitParam(name = "date", value = "2021-9-28")},
        loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String dateFromServletConfig = this.getServletConfig().getInitParameter("date");
        final String dateFromMyServlet = this.getInitParameter("date");
        final String username = req.getParameter("username");
        req.setAttribute("name", "Lee");
        req.removeAttribute("name");
        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1> Hello Servlet username= " + username + "</h1");
        writer.println("<h1> Date from servlet config= " + dateFromServletConfig + "</h1");
        writer.println("<h1> Date from my servlet= " + dateFromMyServlet + "</h1");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String age = req.getParameter("age");
        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1> Hello Servlet name= " + name + "  age=" + age + "</h1");
    }
}