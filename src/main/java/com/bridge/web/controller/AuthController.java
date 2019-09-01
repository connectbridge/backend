package com.bridge.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridge.api.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/loginForm")
	public String loginForm(UsernamePasswordAuthenticationToken usernamePaswwordAuthenticationToken) {
		if (usernamePaswwordAuthenticationToken != null) {
			// 이미 로그인 정보가 있는 경우, main 페이지 리다이렉트
			return "redirect:/main";
		} else {
			// 이미 로그인 정보가 없는 경우, loginForm 으로 이동
			return "auth/loginForm";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		response.sendRedirect(request.getHeader("referer"));
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
