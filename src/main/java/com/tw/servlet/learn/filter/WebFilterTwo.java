package com.tw.servlet.learn.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "two")
public class WebFilterTwo implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request1 = (HttpServletRequest) request;
        log.info("Filter two enter doFilter method, URL={}", request1.getRequestURL());
        chain.doFilter(request, response);
        log.info("Filter two exit doFilter method, URL={}", request1.getRequestURL());

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter two init");
    }

    @Override
    public void destroy() {
        log.info("Filter two destroy");
    }
}
