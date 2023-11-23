package com.example.demo.dto;

public class PostRequest {
	private String title;
	private String text;

	private Long memberId;

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public Long getMemberId() {
		return memberId;
	}
}
