package com.tw.servlet.learn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.servlet.learn.domain.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class ServletRequest extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String contentType = req.getContentType();
        final String header = req.getHeader("User-Agent");
        final String protocol = req.getProtocol();
        final StringBuffer requestURL = req.getRequestURL();
        final String queryString = req.getQueryString();
        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1>" +
                "contenType" + contentType +
                "header" + header +
                "protocol" + protocol +
                "requestURL" + requestURL +
                "queryString" + queryString +
                "</h1>"
        );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line=reader.readLine())!=null){
            stringBuilder.append(line);
        }
        final User user = new ObjectMapper().readValue(stringBuilder.toString(), User.class);
        System.out.println(user);
    }
}
