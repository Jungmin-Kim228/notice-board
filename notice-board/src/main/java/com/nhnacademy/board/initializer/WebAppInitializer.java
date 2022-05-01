package com.nhnacademy.board.initializer;

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

        servletContext.setInitParameter("adminAccount", "admin,12345,관리자");

//        servletContext.setInitParameter("counterFileName", "counter.dat");
//        servletContext.setInitParameter("counter", "0");
    }
}
