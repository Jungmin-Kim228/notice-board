package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Posts.ConcretePost;
import com.nhnacademy.board.domain.Posts.repository.Posts;
import com.nhnacademy.board.domain.Users.repository.Users;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardAddController implements Command {
    private Posts posts;
    private Users users;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        posts = (Posts) request.getServletContext().getAttribute("posts");
        users = (Users) request.getServletContext().getAttribute("users");

        Long receivedId = Long.parseLong(request.getParameter("id"));
        String receivedTitle = request.getParameter("title");
        String receivedContent = request.getParameter("content");
        String receivedWriter = users.getUsers().get(request.getParameter("writer")).getName();
        String receivedTime = request.getParameter("writeTime");

        if (receivedTime.equals("")) {
            posts.register(
                new ConcretePost(receivedId, receivedTitle, receivedContent, receivedWriter));
        } else {
            posts.register(
                new ConcretePost(receivedId, receivedTitle, receivedContent, receivedWriter,
                    LocalDateTime.parse(receivedTime)));
        }

        request.getServletContext().setAttribute("posts", posts);

        return "redirect:/boardList.do";

    }
}
