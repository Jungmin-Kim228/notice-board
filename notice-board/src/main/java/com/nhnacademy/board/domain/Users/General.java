package com.nhnacademy.board.domain.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class General implements User {
    private String id;
    private String pw;
    private String name;
    private String profileFileName;

    public General(String id, String pw, String name, String profileFileName) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.profileFileName = profileFileName;
    }
}
