package com.nhnacademy.board.domain.Posts.repository;

import com.nhnacademy.board.domain.Posts.Post;
import java.util.HashMap;
import java.util.Map;

public class Posts implements PostRepository {
    private Map<Long, Post> posts = new HashMap<>();

    @Override
    public long register(Post post) {
        posts.put(post.getId(), post);
        return post.getId();
    }

    @Override
    public void modify(Post oldPost, Post newPost) {
        this.posts.remove(oldPost.getId());
        this.posts.put(newPost.getId(), newPost);
    }

    @Override
    public Post remove(long id) {
        return this.posts.remove(id);
    }

    @Override
    public Post getPost(long id) {
        return this.posts.get(id);
    }

    @Override
    public Map<Long, Post> getPosts() {
        return this.posts;
    }
}
