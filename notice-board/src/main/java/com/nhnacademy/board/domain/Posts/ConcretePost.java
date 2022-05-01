package com.nhnacademy.board.domain.Posts;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConcretePost implements Post {
    private long id;
    private String title;
    private String content;
    private String writerUserId;
    private LocalDateTime writeTime;
    private int viewCount;

    @Override
    public void increaseViewCount() {
        this.viewCount++;
    }
}
