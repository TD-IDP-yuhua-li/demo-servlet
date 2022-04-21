package com.tw.servlet.learn.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "one")
public class WebFilterOne implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request1 = (HttpServletRequest) request;
        log.info("Filter one enter doFilter method, URL={}", request1.getRequestURL());
        chain.doFilter(request,response);
        log.info("Filter one exit doFilter method, URL={}", request1.getRequestURL());

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter one init");
    }

    @Override
    public void destroy() {
        log.info("Filter one destroy");
    }
}
