package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.User;
import java.util.List;

public interface UserRepository {
    void add(User user);
    void modify(User user);
    User remove(String id);

    User getUser(String id);
    List<User> getUsers(); // Map 쓰는거 고려
}
