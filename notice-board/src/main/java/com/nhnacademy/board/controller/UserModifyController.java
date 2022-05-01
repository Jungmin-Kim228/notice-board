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
        String recievedId = request.getParameter("id");
        String recievedPw = request.getParameter("pw");
        String recievedName = request.getParameter("name");
        String recievedProfile = request.getParameter("profile");

        if (recievedId.equals("")) {
            recievedId = who;
            self = true;
        }
        recievedPw = (!recievedPw.equals("")) ? recievedPw : users.getUsers().get(who).getPw();
        recievedName = (!recievedName.equals("")) ? recievedName : users.getUsers().get(who).getName();
        recievedProfile = (!recievedProfile.equals("")) ? recievedProfile : users.getUsers().get(who).getProfileFileName();

        if (users.getUsers().containsKey(recievedId) && !self) {
            throw new IllegalArgumentException("해당 아이디가 이미 존재합니다.");
        }

        User user = new General(recievedId, recievedPw, recievedName, recievedProfile);

        users.modify(users.getUsers().get(who), user);

        request.getServletContext().setAttribute("users", users);

        return "redirect:/userList.do";
    }
}
