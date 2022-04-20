package com.tw.servlet.learn.application;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.EmptyResourceSet;
import org.apache.catalina.webresources.StandardRoot;


import java.io.File;

@Slf4j
public class WebApplication {

    public static final int PORT = 8080;
    public static final String HOSTNAME = "127.0.0.1";

    public static void main(String[] args) throws LifecycleException {
        start();
    }

    public static void start() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.setHostname(HOSTNAME);
        tomcat.getConnector();
        Context context = tomcat.addWebapp("", new File(".").getAbsolutePath());
        configureResources((StandardContext) context);
        tomcat.start();
        tomcat.getServer().await();
    }

    public static void configureResources(StandardContext standardContext) {
        final String workHome = System.getProperty("user.dir");
        final File classDir = new File(workHome, "target/classes");
        final File jarDir = new File(workHome, "");
        final WebResourceRoot resources = new StandardRoot(standardContext);
        if (classDir.exists()) {
            resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", classDir.getAbsolutePath(), "/"));
            log.info("Resource added: [classes]");
        } else if (jarDir.exists()) {
            resources.addJarResources(new DirResourceSet(resources, "/WEB-INF/lib", jarDir.getAbsolutePath(), "/"));
            log.info("Resource added: [jar]");

        } else {
            resources.addPreResources(new EmptyResourceSet(resources));
            log.info("Resource added: [empty]");

        }
        standardContext.setResources(resources);
    }
}
