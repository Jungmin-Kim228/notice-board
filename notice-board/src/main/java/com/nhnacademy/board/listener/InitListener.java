package com.nhnacademy.board.listener;

import com.nhnacademy.board.domain.Posts.repository.Posts;
import com.nhnacademy.board.domain.Users.Admin;
import com.nhnacademy.board.domain.Users.General;
import com.nhnacademy.board.domain.Users.repository.Users;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class InitListener implements ServletContextListener {
    Users users = new Users();
    Posts posts = new Posts();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String[] adminAccount = servletContext.getInitParameter("adminAccount").split(",");
        String[] generalAccount = servletContext.getInitParameter("generalAccount").split(","); // 테스트를 위해 일반 사용자 삽입

        users.add(new Admin(adminAccount[0], adminAccount[1], adminAccount[2]));
        users.add(new General(generalAccount[0], generalAccount[1], generalAccount[2], generalAccount[3]));

        servletContext.setAttribute("users", users);
        servletContext.setAttribute("posts", posts);
    }
}
