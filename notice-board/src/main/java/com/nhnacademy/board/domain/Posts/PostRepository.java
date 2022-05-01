package com.nhnacademy.board.domain.Posts;

import java.util.List;

public interface PostRepository {
    long register(Post post);
    void modify(Post post);
    Post remove(long id);

    Post getPost(long id);
    List<Post> getPosts(); // Map 쓰는거 고려
}
