package com.nhnacademy.board.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin implements User{
    private String id;
    private String pw;
    private String name;
    private String profileFileName;

    public Admin(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.profileFileName = "null";
    }
}
