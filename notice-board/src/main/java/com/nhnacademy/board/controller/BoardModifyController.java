package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Posts.repository.Posts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardModifyController implements Command {
    private Posts posts;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        posts = (Posts) request.getServletContext().getAttribute("posts");
        HttpSession session = request.getSession(false);

        

        return "/";
    }
}
