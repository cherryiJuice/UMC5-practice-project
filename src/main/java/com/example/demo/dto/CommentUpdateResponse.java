package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentUpdateResponse {

    private String memberName;
    private Long postId;
    private String content;

    @Builder
    public CommentUpdateResponse(String memberName, Long postId, String content) {
        this.memberName = memberName;
        this.postId = postId;
        this.content = content;
    }
}
