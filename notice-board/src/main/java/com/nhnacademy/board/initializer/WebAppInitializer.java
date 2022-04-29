package com.nhnacademy.board.initializer;

import com.nhnacademy.board.domain.Admin;
import com.nhnacademy.board.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
//        Map<String, User> users = new HashMap<>();
//        users.put("admin", new Admin("admin", "12345", "관리자"));
//        servletContext.setAttribute("users", users);

        servletContext.setInitParameter("adminAccount", "admin,12345,관리자");

//        servletContext.setInitParameter("counterFileName", "counter.dat");
//        servletContext.setInitParameter("counter", "0");
    }
}
