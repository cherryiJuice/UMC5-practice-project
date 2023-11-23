package com.example.demo.dto;

import lombok.Getter;

@Getter
public class CommentRequest {

    private String content;

    private Long memberId;
    private Long postId;
}
