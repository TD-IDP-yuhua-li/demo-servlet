package com.tw.servlet.learn.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
@WebListener
public class CustomHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
log.info("Session created");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session destroyed");
    }
}
