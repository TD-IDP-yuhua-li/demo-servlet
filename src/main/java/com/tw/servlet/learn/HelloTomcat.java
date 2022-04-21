package com.tw.servlet.learn;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-tomcat")
public class HelloTomcat extends HttpServlet {
    public static final String AUTHOR_NAME = "author-name";
    public static final String AUTHOR_EMAIL = "author-emial";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String name = req.getServletContext().getInitParameter(AUTHOR_NAME);
        final String email = req.getServletContext().getInitParameter(AUTHOR_EMAIL);
        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1> name= " + name + "</h1");
        writer.println("<h1> email= " + email + "</h1");
    }
}
