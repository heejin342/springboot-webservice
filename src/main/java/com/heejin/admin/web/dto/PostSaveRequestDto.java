package com.heejin.admin.web.dto;


import com.heejin.admin.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//Entity class 아님 !! Dto 임 . == Request, Response 용 ! -> controller에서 매핑 후에 사용된다
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
