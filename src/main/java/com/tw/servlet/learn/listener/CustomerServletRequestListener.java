package com.tw.servlet.learn.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

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
