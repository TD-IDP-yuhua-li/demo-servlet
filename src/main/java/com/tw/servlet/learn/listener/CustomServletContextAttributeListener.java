package com.tw.servlet.learn.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


@WebListener
@Slf4j
public class CustomServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        log.info("Attribute added name = {},value = {}", event.getName(), event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        log.info("Attribute removed name = {},value = {}", event.getName(), event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeReplaced(event);
    }
}
