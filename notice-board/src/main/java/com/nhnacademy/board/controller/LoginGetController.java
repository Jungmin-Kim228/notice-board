package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import com.nhnacademy.board.domain.Users.User;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginGetController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Map<String, User> users =
            (Map<String, User>) request.getServletContext().getAttribute("users");

        // Todo: erase
        log.info("login get controller");
        // session이 없거나 로그인하지 않았을 경우
        if ((Objects.isNull(session)) ||
            (Objects.nonNull(session) && !users.containsKey(session.getAttribute("id")))) {
            return "/loginForm.jsp";
        } else { // 로그인했을 경우
            if (session.getAttribute("id").equals("admin"))
                return "redirect:/userList.jsp"; // 관리자 모드
            return "redirect:/boardList.jsp"; // 일반 모드
        }
    }
}
