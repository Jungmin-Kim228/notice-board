package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Posts.repository.Posts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardDeleteController implements Command {
    Posts posts;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        posts = (Posts) request.getServletContext().getAttribute("posts");
        HttpSession session = request.getSession(false);

        String deleteId = request.getParameter("which");
        Long parsedId = Long.parseLong(deleteId);

        if (!session.getAttribute("id").equals(posts.getPost(parsedId).getWriterUserId())) {
            throw new IllegalStateException("해당 게시물 삭제 권한이 없습니다.");
        }

        posts.remove(parsedId);

        request.getServletContext().setAttribute("posts", posts);

        return "redirect:/boardList.do";
    }
}
