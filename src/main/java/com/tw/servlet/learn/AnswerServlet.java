package com.tw.servlet.learn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        final String name = session.getAttribute("name").toString();
        final PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        if (name.isEmpty()) {
            writer.println("<h1>I don't know you </h1>");

        } else {
            writer.println("<h1>Hello , I'm " + name + " <h1>");
        }
    }
}
