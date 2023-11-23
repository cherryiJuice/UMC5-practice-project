package com.example.demo.controller;

import com.example.demo.dto.CommentRequest;
import com.example.demo.dto.CommentUpdateRequest;
import com.example.demo.dto.CommentUpdateResponse;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public String leaveComment(@RequestBody CommentRequest commentRequest) {
        return commentService.leave(commentRequest).toString();
    }

    @PatchMapping("/comments")
    public CommentUpdateResponse updateComment(@RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.update(commentUpdateRequest);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id) {
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
