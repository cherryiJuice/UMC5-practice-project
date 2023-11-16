package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.dto.MemberUpdateRequest;
import com.example.demo.dto.MemberUpdateResponse;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public void join(SignUpRequest request) {
		Member member = Member.builder()
				.name(request.getName())
				.age(request.getAge())
				.gender(request.getGender())
				.build();
		memberRepository.save(member);
	}

	@Transactional
	public MemberDto findById(Long id) {
		Member member = memberRepository.findById(id).orElseThrow();
		return MemberDto.builder()
				.id(member.getId())
				.name(member.getName())
				.age(member.getAge())
				.gender(member.getGender())
				.build();
	}

	@Transactional
	public MemberUpdateResponse updateMember(MemberUpdateRequest request) {
		Member member = memberRepository.findById(request.getId()).orElseThrow();
		member.setName(request.getName());
		member.setAge(request.getAge());
		member.setGender(request.getGender());

		return MemberUpdateResponse.builder()
				.name(member.getName())
				.age(member.getAge())
				.gender(member.getGender())
				.build();
	}
}
