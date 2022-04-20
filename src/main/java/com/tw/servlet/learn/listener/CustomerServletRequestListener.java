package com.tw.servlet.learn.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class CustomerServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        final StringBuffer requestURL = httpServletRequest.getRequestURL();
        final String method = httpServletRequest.getMethod();
        final String serverName = httpServletRequest.getServerName();
        log.info("Request Destroyed URL={},METHOD={},SERVER_NAME+{}", requestURL, method, serverName);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        final StringBuffer requestURL = httpServletRequest.getRequestURL();
        final String method = httpServletRequest.getMethod();
        final String serverName = httpServletRequest.getServerName();
        log.info("Request Initialized URL={},METHOD={},SERVER_NAME+{}", requestURL, method, serverName);
    }
}
