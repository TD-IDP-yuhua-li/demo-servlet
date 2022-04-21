package com.tw.servlet.learn.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@Slf4j
@WebListener
public class CustomServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info("Servlet context initialized");

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info("Servlet context destroyed");

    }
}
