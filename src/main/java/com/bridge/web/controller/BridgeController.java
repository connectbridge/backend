package com.bridge.web.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridge.api.dto.Member;

@Controller
public class BridgeController {
	@RequestMapping("")
	public String index() {
		return "main";
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/id/{memberId}")
	public String personalPage(@PathVariable("memberId") String memberId,
			ModelMap modelMap,
			UsernamePasswordAuthenticationToken usernamePaswwordAuthenticationToken) {
		if (usernamePaswwordAuthenticationToken != null) {
			Member member = (Member) usernamePaswwordAuthenticationToken.getPrincipal();
			modelMap.addAttribute("loginId", member.getsId());
		}

		modelMap.addAttribute("memberId", memberId);
		return "personalPage";
	}

	@RequestMapping("/join")
	public String join() {
		return "join";
	}
}