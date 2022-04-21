package com.tw.servlet.learn;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ask")
@Slf4j
public class AskServlet extends HttpServlet {
    public static final String NAME = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1> Hello !</h1");
        final HttpSession session = req.getSession();
        final int maxInactiveInterval = session.getMaxInactiveInterval();
        log.info("maxInactiveInterval is {}", maxInactiveInterval);
        session.setAttribute(NAME, "Lee");
    }


}
