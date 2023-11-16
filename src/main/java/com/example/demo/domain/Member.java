package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.*;

// Member의 구성요소 - id, 이름, 닉네임, 나이, 성별
@Entity
@Getter
@Setter
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;

	private String name;

	private Integer age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Builder
	public Member(String name, Integer age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	/**
	 * 이건 지우지말고 냅두세요
	 */
	protected Member() {
	}

}
