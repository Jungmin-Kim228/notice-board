package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.User;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginPostController implements Command {
    private Map<String, User> users;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        users = (Map<String, User>) request.getServletContext().getAttribute("users");

        String receivedId = request.getParameter("id");
        String receivedPw = request.getParameter("pw");

        // Todo: erase
        log.error(users.get("admin").getId() +" " + users.get("admin").getPw());
        log.error("receivedId: "+receivedId+", receivedPw: "+receivedPw);
        if (users.containsKey(receivedId) && users.get(receivedId).getPw().equals(receivedPw)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", receivedId);
//            session.setAttribute("redirect", request.getRequestURI());

            return "redirect:/login.do";
        }

        return "/loginForm.jsp";
    }
}
