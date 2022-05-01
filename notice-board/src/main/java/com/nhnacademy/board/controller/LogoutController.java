package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.User;
import com.nhnacademy.board.domain.Users.repository.Users;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogoutController implements Command {
    private Users users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Users) request.getServletContext().getAttribute("users");

        HttpSession session = request.getSession(false);
        if (Objects.nonNull(session) && users.getUsers().containsKey(session.getAttribute("id"))) {
            log.info("session logout");
            session.invalidate();
        }
        return "redirect:/";
    }
}
