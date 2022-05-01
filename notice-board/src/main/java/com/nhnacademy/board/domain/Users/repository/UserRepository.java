package com.nhnacademy.board.domain.Users.repository;

import com.nhnacademy.board.domain.Users.User;
import java.util.Map;

public interface UserRepository {
    void add(User user);
    void modify(User oldUser, User newUser);
    User remove(String id);

    User getUser(String id);
    Map<String, User> getUsers();
}
