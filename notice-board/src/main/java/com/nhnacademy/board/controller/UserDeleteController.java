package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.User;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteController implements Command {
    private Map<String, User> users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Map<String, User>) request.getServletContext().getAttribute("users");

        String deleteId = request.getParameter("who");
        users.remove(deleteId);

        request.getServletContext().setAttribute("users", users);

        return "redirect:/userList.do";
    }
}
