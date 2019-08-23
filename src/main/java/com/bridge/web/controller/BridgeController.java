package com.bridge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BridgeController {
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/p/{memberId}")
	public String personalPage(@PathVariable("memberId") String memberId, ModelMap modelMap) {
		modelMap.addAttribute("memberId", memberId);
		return "personalPage";
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping("/join")
	public String join() {
		return "join";
	}
}