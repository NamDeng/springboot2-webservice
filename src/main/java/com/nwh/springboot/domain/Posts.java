package com.nwh.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // JPA annotatio. 테이블과 링크될 클래스.
public class Posts {

    /**
     * @GeneratedValue strategy 종류
     * AUTO :  (persistence provider가) 특정 DB에 맞게 자동 선택
     * SEQUENCE : DB 시퀀스 컬럼을 이용
     * IDENTITY : DB identity 컬럼을 이용. ( spring boot2 이상 auto_increment )
     * TABLE : 유일성이 보장된 데이터베이스 테이블을 이용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;


    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
