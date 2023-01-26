package com.training.pastries;

import com.training.pastries.dao.JPAUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.shutDown();
    }
}
