package com.tw.servlet.learn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    public static final String MESSAGE = "message";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String message = req.getServletContext().getAttribute(MESSAGE).toString();
        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1> Get the message from HelloTomcat servlet: " + message + "</h1");
    }
}
