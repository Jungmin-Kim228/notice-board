package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Posts.ConcretePost;
import com.nhnacademy.board.domain.Posts.Post;
import com.nhnacademy.board.domain.Posts.repository.Posts;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyPostController implements Command {
    private Posts posts;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        posts = (Posts) request.getServletContext().getAttribute("posts");
        Post post;

        Long which = Long.parseLong(request.getParameter("which"));
        String receivedTitle = request.getParameter("title");
        String receivedContent = request.getParameter("content");
        String receivedWriter = request.getParameter("writer");
        String receivedTime = request.getParameter("writeTime");

        if (receivedTime.equals("")) {
            post = new ConcretePost(which, receivedTitle, receivedContent, receivedWriter);
        } else {
            post = new ConcretePost(which, receivedTitle, receivedContent, receivedWriter,
                    LocalDateTime.parse(receivedTime));
        }

        posts.modify(posts.getPost(which), post);

        request.getServletContext().setAttribute("posts", posts);

        return "redirect:/boardList.do";
    }
}
