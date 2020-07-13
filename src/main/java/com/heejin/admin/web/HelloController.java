package com.heejin.admin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//JSON 을 반환하는 컨트롤러
@RestController
public class HelloController {

    //HTTP method 인 get을 요청받을 수 있는 API
    @GetMapping("/hello")
    public String hello(){
        //   /hello Get요청이 오면 string hello 를 리턴해준다.
        return "hello";
    }
}
