package com.heejin.admin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//선언된 모듵 필드의 get 메소드 생성
@Getter
//final 이 포함된 생성자를 생성한다. 꼭 파이널 필욯람
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
