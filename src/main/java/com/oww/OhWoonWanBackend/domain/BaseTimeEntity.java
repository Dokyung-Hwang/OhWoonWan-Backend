package com.oww.OhWoonWanBackend.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass // Jpa Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 Column으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)      // BaseTimeEntity 클래스에 Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate
    private String createdDate;

    @LastModifiedDate
    private String modifiedDate;

    // 해당 Entity 를 저장하기 이전에 실행
    @PrePersist
    public void onPrePersist() {
        this.createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.modifiedDate = this.createdDate;
    }

    // 해당 Entity 를 업데이트 하기 이전에 실행
    @PreUpdate
    public void onPreUpdate() {
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
