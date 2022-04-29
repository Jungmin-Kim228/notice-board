package com.nhnacademy.board.domain;

public interface User {
    String getId();
    void setId(String id);

    String getPw();
    void setPw(String pw);

    String getName();
    void setName(String name);

    String getProfileFileName();
    void setProfileFileName(String profileFileName);
}
