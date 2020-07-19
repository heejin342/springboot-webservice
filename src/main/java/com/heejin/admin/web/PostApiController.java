package com.heejin.admin.web;

import com.heejin.admin.service.PostService;
import com.heejin.admin.web.dto.PostSaveRequestDto;
import com.heejin.admin.web.dto.PostUpdateRequestDto;
import com.heejin.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
//JSON 반환 컨트롤러 -> url 매핑 필요
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

}
