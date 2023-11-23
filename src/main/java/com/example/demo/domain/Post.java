package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private String title;

	@ManyToOne(fetch = FetchType.LAZY) //디폴트 EAGER
	private Member member;

	public Post(String text, String title, Member member) {
		this.text = text;
		this.title = title;
		this.member = member;
	}

	protected Post() {
	}
}
