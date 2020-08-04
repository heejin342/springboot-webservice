package com.heejin.admin.web.dto;

import com.heejin.admin.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Controller 에서 url 매핑을하는듯
//리턴값이랑 mustache 이름이랑 같아야한다
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        // 새로운 데이터베이스 추가하는 문장
        model.addAttribute("posts",postService.findAllDesc());
        //리턴값은 머스테치 이름이랑 같아야함        
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        // 있던거에서 id로 찾는 문장
        PostsResponseDto dto = postService.findById(id);
        // 새로운 데이터베이스 추가하는 문장
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
