package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.User;
import com.nhnacademy.board.domain.Users.repository.Users;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteController implements Command {
    private Users users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Users) request.getServletContext().getAttribute("users");

        String deleteId = request.getParameter("who");
        users.remove(deleteId);

        request.getServletContext().setAttribute("users", users);

        return "redirect:/userListForAdmin.do";
    }
}
