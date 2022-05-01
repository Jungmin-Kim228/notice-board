package com.nhnacademy.board.domain.Posts.repository;

import com.nhnacademy.board.domain.Posts.Post;
import java.util.Map;

public interface PostRepository {
    long register(Post post);
    void modify(Post oldPost, Post newPost);
    Post remove(long id);

    Post getPost(long id);
    Map<Long, Post> getPosts();
}
