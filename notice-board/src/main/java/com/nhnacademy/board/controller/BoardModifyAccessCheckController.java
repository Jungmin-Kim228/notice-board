package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Posts.repository.Posts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardModifyAccessCheckController implements Command {
    private Posts posts;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        posts = (Posts) request.getServletContext().getAttribute("posts");
        HttpSession session = request.getSession(false);

        String receivedPostId = request.getParameter("which");
        Long parsedId = Long.parseLong(receivedPostId);

        if (!session.getAttribute("id").equals(posts.getPost(parsedId).getWriterUserId())) {
            throw new IllegalStateException("해당 게시물 수정 권한이 없습니다.");
        }

        return "/boardModify.jsp";
    }
}
