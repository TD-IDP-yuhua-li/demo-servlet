package com.tw.servlet.learn.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class CustomServletRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
        final StringBuffer requestURL = httpServletRequest.getRequestURL();
        final String method = httpServletRequest.getMethod();
        final String name = srae.getName();
        final Object value = srae.getValue();
        log.info("AttributeAdded NAME={} VALUE={} URL={},METHOD={}", name, value, requestURL, method);

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
        final StringBuffer requestURL = httpServletRequest.getRequestURL();
        final String method = httpServletRequest.getMethod();
        final String name = srae.getName();
        final Object value = srae.getValue();
        log.info("Attribute Remove NAME={} VALUE={} URL={},METHOD={}", name, value, requestURL, method);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
