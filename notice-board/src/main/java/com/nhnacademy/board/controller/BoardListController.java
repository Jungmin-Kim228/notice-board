package com.nhnacademy.board.controller;

import com.nhnacademy.board.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/boardList.jsp";
    }
}
