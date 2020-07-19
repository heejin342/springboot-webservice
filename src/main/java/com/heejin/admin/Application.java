package com.heejin.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//스프링부트의 자동설정, bean 읽기와 생성을 자동으로 설정함.
//프로젝트 젤 상단에 위치해야한다.
@SpringBootApplication
//JPA autiting 활성화
@EnableJpaAuditing
//프로젝트 메인클래스
public class Application {
    public static void main(String[] args){
        //내장WAS서버 실행
        SpringApplication.run(Application.class, args);
    }
}
