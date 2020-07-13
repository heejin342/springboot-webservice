package com.heejin.admin;

import com.heejin.admin.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 스프링부트워 Jnit 연동
@RunWith(SpringRunner.class)
//Spring MVC 와 연동. 연동할 controller은 HelloController
@WebMvcTest(controllers= HelloController.class)
public class HelloControllerTest {

    // 스프링이 관리하는 빈(Bean) 을 주입받음
    @Autowired
    // mvc 는 웹API 를 테스트할때 사용됨. 이를 통해 Http POST, GET 이 가능해진다.
    private MockMvc mvc;

    @Test
    public void hello_리턴되나() throws Exception{
        String hello = "hello";

        // hello 주소로 http get 요청을 합
        mvc.perform(get("/hello"))
                //헤더의 상태가 200인지 아닌지 체크
                .andExpect(status().isOk())
                //헬로컨트롤러에서 hello 를 리턴시켰기 때문에, 내용이 String 이 맞는지 확인함
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDtor가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;
        // param은 API 테스트할떄 사용될 요청 파라미터 설정. String 값만 허용해서 문자열로 무조건 변경해야한다.
        mvc.perform(get("/hello/dto").param("name", name)
                                               .param("amount", String.valueOf(amount)))
                                                                                        .andExpect(status().isOk())
                                                                                        .andExpect(jsonPath("$.name", is(name)))
                                                                                        .andExpect(jsonPath("$.amount", is(amount)));
                                                //Json 응답값을 검증. $를 기준으로 필드명을 명시.name과 amount 응답값을 검증한다.
    }
}

//테스트가 성공한다면, 컨트롤러를 실행시켜보지 않아도 성공했다는것을 알 수 있다