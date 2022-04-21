package com.tw.servlet.learn.application;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import java.util.Set;

@Slf4j
public class WebApplicationServletContainerInitializer implements ServletContainerInitializer {

    public static final String LEE_MAIL_COM = "Lee@mail.com";
    public static final String AUTHOR_EMAIL = "author-mail";
    public static final String AUTHOR_NAME = "author-name";
    public static final String LEE = "Lee";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        log.info("Set servlet context init parameter");
        ctx.setInitParameter(AUTHOR_NAME, LEE);
        ctx.setInitParameter(AUTHOR_EMAIL, LEE_MAIL_COM);
    }
}
