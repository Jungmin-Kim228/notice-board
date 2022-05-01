package com.nhnacademy.board.listener;

import com.nhnacademy.board.domain.Users.Admin;
import com.nhnacademy.board.domain.Users.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class InitListener implements ServletContextListener {
    Map<String, User> users = new HashMap<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String[] adminAccount = servletContext.getInitParameter("adminAccount").split(",");

        users.put(adminAccount[0], new Admin(adminAccount[0], adminAccount[1], adminAccount[2]));

        servletContext.setAttribute("users", users);
    }
}
