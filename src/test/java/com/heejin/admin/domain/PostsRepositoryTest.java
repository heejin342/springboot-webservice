package com.heejin.admin.domain;


import com.heejin.admin.domain.posts.Posts;
import com.heejin.admin.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest   //H2 데이터베이스를 사용할 수 있음
public class PostsRepositoryTest {

    @Autowired //Spring bean 주입
            PostsRepository postsRepository;

    // jUnit 단위 테스트가 끝나면 수행된다. delete!
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // 이걸 통해 아까 Posts 함수 빌드를 대신 해줌. 이때 Posts서 칼럼값에 설정했던 final 변수들과 이 데이터들이 들어가서 빌드된다.
        // post 테이블에 insert/ update 쿼리를 실행한다 (첨일때만 insert)
        postsRepository.save(Posts.builder()
                                         .title(title)
                                         .content(content)
                                         .author("heejin.com")
                                         .build());

        //postsList 는 데이터베이스에 저장된 내용임. 모든 데이터들을 찾는 내용
        List<Posts> postsList = postsRepository.findAll();

        // db 에서 get(0) 즉 첫번째 데이터 행을 가져온다
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title); //첫번째 데이터 행에서 title을 가져온게 title 이랑 동일한지 확인한다.
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){

        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder().title("title")
                                                  .content("content")
                                                  .author("author")
                                                  .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> createdDate=" + posts.getCreatedDate()+", modifiedDate=" +posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}

