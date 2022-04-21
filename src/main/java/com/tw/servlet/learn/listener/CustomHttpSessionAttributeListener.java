package com.tw.servlet.learn.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@Slf4j
@WebListener
public class CustomHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        log.info("Attribute added name={}, value={}", event.getName(), event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }
}
