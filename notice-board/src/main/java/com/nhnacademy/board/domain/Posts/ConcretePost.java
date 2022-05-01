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
    private String writerUserName;
    private LocalDateTime writeTime;
    private int viewCount;

    public ConcretePost(long id, String title, String content, String writerUserName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerUserName = writerUserName;
        this.writeTime = LocalDateTime.now();
        this.viewCount = 0;
    }

    public ConcretePost(long id, String title, String content, String writerUserName,
                        LocalDateTime writeTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerUserName = writerUserName;
        this.writeTime = writeTime;
    }

    @Override
    public void increaseViewCount() {
        this.viewCount++;
    }
}
