package com.heejin.admin.service;

import com.heejin.admin.domain.posts.Posts;
import com.heejin.admin.domain.posts.PostsRepository;
import com.heejin.admin.web.dto.PostSaveRequestDto;
import com.heejin.admin.web.dto.PostUpdateRequestDto;
import com.heejin.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//생성자 생성을 통해 bean 객체를 받도록 한다.
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다 id= " + id));
        return new PostsResponseDto(entity);
    }
}
