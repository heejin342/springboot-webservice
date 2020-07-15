package com.heejin.admin.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//롬복관련 @
@Getter
@NoArgsConstructor   //post(){}생성자추가
//JPA 관련 @
@Entity
// ENtity 클래스는 보통 setter 메소드가 없다 !
public class Posts {   //Posts 클래스는 db 테이블과 직접적으로 매칭될 Entity class라고 부른다
    @Id    //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //id 롤 autoincrement 하겠다는 의미
    private Long id;

    // 모든 column 에 private를 선언했다.
    @Column(length=500, nullable=false)
    private String title;

    @Column(columnDefinition ="Text" , nullable=false)
    private String content;

    private String author;

    //나중에 빌더를 호출해서 테이블을 create 할꺼임 (JPA 중요성 !)
    @Builder
    public Posts(String title, String content, String author){
        this.title= title;
        this.content=content;
        this.author=author;
    }

}
