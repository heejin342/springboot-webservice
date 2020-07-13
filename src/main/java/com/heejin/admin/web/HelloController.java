package com.heejin.admin.web;

import com.heejin.admin.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/hello/dto")
    // RequestParam 은 오부에서 APi 로 넘긴 파라미터를 가져오는 annotation. @RequestParam("name") 이름으로 넘겨서 String name 으로 받는다
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
