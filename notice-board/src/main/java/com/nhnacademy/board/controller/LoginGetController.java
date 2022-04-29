package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.User;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginGetController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, User> users =
            (Map<String, User>) request.getServletContext().getAttribute("users");

        log.info("login get controller");
        if (Objects.isNull(session)) {
            log.info("login get controller session is null");
            return "/loginForm.jsp";
        } else {
            if (!users.containsKey(session.getAttribute("id"))) {
                log.error("aaaaaaaaa - " + users.get("admin").getId());
                log.error("session attribute - " +session.getAttribute("id"));
                return "/loginForm.jsp";
            }
        }
        return "/boardList.jsp";
    }
}
