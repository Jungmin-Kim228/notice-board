package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.General;
import com.nhnacademy.board.domain.Users.User;
import com.nhnacademy.board.domain.Users.repository.Users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserModifyController implements Command {
    private Users users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Users) request.getServletContext().getAttribute("users");
        boolean self = false;

        String who = request.getParameter("who");
        String receivedId = request.getParameter("id");
        String receivedPw = request.getParameter("pw");
        String receivedName = request.getParameter("name");
        String receivedProfile = request.getParameter("profile");

        if (receivedId.equals("")) {
            receivedId = who;
            self = true;
        }
        receivedPw = (!receivedPw.equals("")) ? receivedPw : users.getUsers().get(who).getPw();
        receivedName = (!receivedName.equals("")) ? receivedName : users.getUsers().get(who).getName();
        receivedProfile = (!receivedProfile.equals("")) ? receivedProfile : users.getUsers().get(who).getProfileFileName();

        if (users.getUsers().containsKey(receivedId) && !self) {
            throw new IllegalArgumentException("해당 아이디가 이미 존재합니다.");
        }

        User user = new General(receivedId, receivedPw, receivedName, receivedProfile);

        users.modify(users.getUsers().get(who), user);

        request.getServletContext().setAttribute("users", users);

        return "redirect:/userListForAdmin.do";
    }
}
