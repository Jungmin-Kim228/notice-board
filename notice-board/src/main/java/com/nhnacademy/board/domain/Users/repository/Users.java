package com.nhnacademy.board.domain.Users.repository;

import com.nhnacademy.board.domain.Users.User;
import java.util.HashMap;
import java.util.Map;

public class Users implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void add(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public void modify(User oldUser, User newUser) {
        this.users.remove(oldUser.getId());
        this.users.put(newUser.getId(), newUser);
    }

    @Override
    public User remove(String id) {
        return this.users.remove(id);
    }

    @Override
    public User getUser(String id) {
        return this.users.get(id);
    }

    @Override
    public Map<String, User> getUsers() {
        return this.users;
    }
}
