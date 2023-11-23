 package com.example.demo.controller;

 import com.example.demo.dto.MemberDto;
 import com.example.demo.dto.MemberUpdateRequest;
 import com.example.demo.dto.MemberUpdateResponse;
 import com.example.demo.dto.SignUpRequest;
 import lombok.RequiredArgsConstructor;
 import org.springframework.web.bind.annotation.*;

 import com.example.demo.service.MemberService;


 @RestController
 @RequiredArgsConstructor
 public class MemberController {

 	private final MemberService memberService;

     @PostMapping("/members/join")
     public String join(@RequestBody SignUpRequest request) {
         Long memberId = memberService.join(request);
         return memberId.toString();
     }


 	@GetMapping("/members")
 	public MemberDto getMemberDto(Long memberId) {
        return memberService.findById(memberId);
    }

 	@PatchMapping("/members")
 	public MemberUpdateResponse update(
 		@RequestBody MemberUpdateRequest request
 	) {
        return memberService.updateMember(request);
    }

 }
