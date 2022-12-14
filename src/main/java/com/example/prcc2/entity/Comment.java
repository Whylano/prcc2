package com.example.prcc2.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade =  CascadeType.PERSIST,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "MEMBER_ID",nullable = false)
    private Member member;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;


    public Comment(Member member,String content,Post post) {

        this.member = member;
        this.content = content;
        this.post = post;
    }
}
