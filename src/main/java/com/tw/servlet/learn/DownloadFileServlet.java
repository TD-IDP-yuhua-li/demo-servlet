package com.tw.servlet.learn;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download")
public class DownloadFileServlet extends HttpServlet {

    public static final int BUFFER_SIZE = 1048;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.addHeader("Content-disposition", "attachment;filename=simple.txt");
        try (InputStream inputStream = this.getClass().getResourceAsStream("/test.txt")) {
            ServletOutputStream outputStream = resp.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int numBytesRead;
            while ((numBytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, numBytesRead);

            }
        }
    }
}
