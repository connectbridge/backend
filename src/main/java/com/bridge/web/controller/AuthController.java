package com.bridge.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@GetMapping("/auth/loginForm")
	public String loginForm(@PathVariable("memberId") String memberId, ModelMap modelMap) {
		modelMap.addAttribute("memberId", memberId);
		return "/auth/loginForm";
	}

}
