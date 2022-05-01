package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.General;
import com.nhnacademy.board.domain.Users.repository.Users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAddController implements Command {
    private Users users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Users) request.getServletContext().getAttribute("users");

        String receivedId = request.getParameter("id");
        String receivedPw = request.getParameter("pw");
        String receivedName = request.getParameter("name");
        String receivedProfile = request.getParameter("profile");

        if (users.getUsers().containsKey(receivedId)) {
            throw new IllegalArgumentException("해당 아이디가 이미 존재합니다.");
        }

        users.add(new General(receivedId, receivedPw, receivedName, receivedProfile));

        request.getServletContext().setAttribute("users", users);

        return "redirect:/userListForAdmin.do";
    }
}
