package com.heejin.admin.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


//모든 Entity 의 상위클래스가 되어 ENtity 들의 createdDate, notifieDate 등을 자동으로 관리하는 역할임.
@Getter
@MappedSuperclass //ENtity class 상속시 두 private 필드를 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class)   //Auditing 기능 포함시킴
public abstract class BaseTimeEntity {

    @CreatedDate     //entity가 생성되어 저장될때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate    //변경시에도 시간 자동저장
    private LocalDateTime modifiedDate;
}
