package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.General;
import com.nhnacademy.board.domain.Users.User;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserModifyController implements Command {
    private Map<String, User> users;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Map<String, User>) request.getServletContext().getAttribute("users");

        String who = request.getParameter("who");
        String recievedId = request.getParameter("id");
        String recievedPw = request.getParameter("pw");
        String recievedName = request.getParameter("name");
        String recievedProfile = request.getParameter("profile");

        recievedId = (!recievedId.equals("")) ? recievedId : users.get(who).getId();
        recievedPw = (!recievedPw.equals("")) ? recievedPw : users.get(who).getPw();
        recievedName = (!recievedName.equals("")) ? recievedName : users.get(who).getName();
        recievedProfile = (!recievedProfile.equals("")) ? recievedProfile : users.get(who).getProfileFileName();

        if (users.containsKey(recievedId)) {
            throw new IllegalArgumentException("해당 아이디가 이미 존재합니다.");
        }

        User user = new General(recievedId, recievedPw, recievedName, recievedProfile);

        users.remove(who);
        users.put(recievedId, user);

        request.getServletContext().setAttribute("users", users);

        return "redirect:/userList.do";
    }
}
