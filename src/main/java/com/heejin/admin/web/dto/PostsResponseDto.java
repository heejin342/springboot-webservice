package com.heejin.admin.web.dto;

import com.heejin.admin.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    // 생성자로 entity를 받아 필드에 값을 넣습니다.
    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
