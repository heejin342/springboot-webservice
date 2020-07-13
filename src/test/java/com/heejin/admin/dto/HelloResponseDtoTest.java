package com.heejin.admin.dto;

import com.heejin.admin.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        String name = "test";
        int amount = 1000;

        //위에서 import 한 helloResponseDto 객체를 생성함
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // 검증하고 싶은 대상을 메소드 인자로 받음. 같아야만 성공이다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
