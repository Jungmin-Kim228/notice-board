package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.repository.Users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginPostController implements Command {
    private Users users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Users) request.getServletContext().getAttribute("users");

        String receivedId = request.getParameter("id");
        String receivedPw = request.getParameter("pw");

        if (users.getUsers().containsKey(receivedId) &&
            users.getUsers().get(receivedId).getPw().equals(receivedPw)) {

            HttpSession session = request.getSession();
            session.setAttribute("id", receivedId);

            return "redirect:/login.do";
        }

        return "/loginForm.jsp";
    }
}
