package com.heejin.admin.web;

import com.heejin.admin.service.PostService;
import com.heejin.admin.web.dto.PostSaveRequestDto;
import com.heejin.admin.web.dto.PostUpdateRequestDto;
import com.heejin.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//API 구현
@RequiredArgsConstructor
@RestController
//JSON 반환 컨트롤러 -> url 매핑 필요
public class PostApiController {
    private final PostService postService;
    //create
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    //게시글 수정 API , update
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    //Read
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    //delete
    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }
}

//save, update, delete 함수들으 postService에 있음
