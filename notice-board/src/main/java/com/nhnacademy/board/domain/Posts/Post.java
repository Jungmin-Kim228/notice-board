package com.nhnacademy.board.domain.Posts;

import java.time.LocalDateTime;

public interface Post {
    long getId(); // 게시물 등록 시 id 반환
    void setId(long id);

    String getTitle();
    void setTitle(String title);

    String getContent();
    void setContent(String content);

    String getWriterUserId();
    void setWriterUserId(String writerUserId);

    LocalDateTime getWriteTime();
    void setWriteTime(LocalDateTime writeTime);

    int getViewCount();
    void increaseViewCount();
}
