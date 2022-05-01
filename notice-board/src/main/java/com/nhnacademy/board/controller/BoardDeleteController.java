package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Posts.repository.Posts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteController implements Command {
    Posts posts;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        posts = (Posts) request.getServletContext().getAttribute("posts");

        String deleteId = request.getParameter("which");
        posts.remove(Long.parseLong(deleteId));

        request.getServletContext().setAttribute("posts", posts);

        return "redirect:/boardList.do";
    }
}
