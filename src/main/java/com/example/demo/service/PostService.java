package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Post;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PostUpdateRequest;
import com.example.demo.dto.PostUpdateResponse;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;
	private final MemberRepository memberRepository;

	@Autowired
	public PostService(PostRepository postRepository, MemberRepository memberRepository) {
		this.postRepository = postRepository;
		this.memberRepository = memberRepository;
	}


	@Transactional
	public Long post(PostRequest request) {
		Member member = memberRepository.findById(request.getMemberId()).get();
		// LAZY LOADING <-> EAGER LOADING
//		List<Post> posts = member.getPostList();
		Post post = new Post(request.getTitle(), request.getText(), member);
		Post savedPost = postRepository.save(post);
		return savedPost.getId();
	}

	@Transactional
	public PostDto getPost(Long postId) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		Post post = optionalPost.get();

		PostDto dto = new PostDto(post.getId(), post.getTitle(), post.getText());

		return dto;
	}


	@Transactional
	public PostUpdateResponse updatePost(PostUpdateRequest request) {
		// 조회하는 것은 위와 같음
		Optional<Post> optionalPost = postRepository.findById(request.getId());
		Post post = optionalPost.get();

		// 조회후 엔티티 내부의 필드 변경
		post.setTitle(request.getTitle());
		post.setText(request.getText());

		return new PostUpdateResponse(
			post.getText(),
			post.getTitle()
		);
	}



}
