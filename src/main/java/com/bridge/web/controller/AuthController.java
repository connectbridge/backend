package com.bridge.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridge.api.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/loginForm")
	public String loginForm(
			UsernamePasswordAuthenticationToken usernamePaswwordAuthenticationToken) {
		if (usernamePaswwordAuthenticationToken != null) {
			// 이미 로그인 정보가 있는 경우, main 페이지 리다이렉트
			return "redirect:/main";
		} else {
			// 이미 로그인 정보가 없는 경우, loginForm 으로 이동
			return "auth/loginForm";
		}
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "auth/joinForm";
	}

	@GetMapping("/modifyInfoForm")
	public String modifyInfoForm() {
		return "auth/modifyInfoForm";
	}
}
