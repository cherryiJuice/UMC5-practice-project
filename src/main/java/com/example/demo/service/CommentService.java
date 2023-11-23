package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Member;
import com.example.demo.domain.Post;
import com.example.demo.dto.CommentRequest;
import com.example.demo.dto.CommentUpdateRequest;
import com.example.demo.dto.CommentUpdateResponse;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    //댓글 작성, 댓글 수정, 댓글 삭제

    @Transactional
    public Long leave(CommentRequest commentRequest) {
        Member member = memberRepository.findById(commentRequest.getMemberId()).orElseThrow();
        Post post = postRepository.findById(commentRequest.getPostId()).orElseThrow();

        Comment comment = Comment.builder()
                .content(commentRequest.getContent())
                .member(member)
                .post(post)
                .build();
        commentRepository.save(comment);
        return comment.getId();
    }

    @Transactional
    public CommentUpdateResponse update(CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentUpdateRequest.getId()).orElseThrow();
        comment.updateContent(commentUpdateRequest.getContent());
        return CommentUpdateResponse.builder()
                .content(comment.getContent())
                .memberName(comment.getMember().getName())
                .postId(comment.getPost().getId())
                .build();
    }

    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        commentRepository.delete(comment);
    }
}
