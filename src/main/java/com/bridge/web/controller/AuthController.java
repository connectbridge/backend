package com.bridge.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bridge.api.service.MemberService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	MemberService memberService;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "auth/loginForm";
	}

	@PostMapping("/loginProcess")
	public void loginProcess(
			@RequestParam(value="id") String id,
			@RequestParam(value="password") String password, ModelMap modelMap) throws Exception {
		modelMap.put("id", id);
		modelMap.put("password", password);

		Map<String, Object> selectParam = new HashMap<String, Object>();
		if (id != null) selectParam.put("id", id);
		if (password != null) selectParam.put("password", password);

		Long aaa =memberService.getCountMember(selectParam);

		System.out.println("CALL : /auth/loginProcee");
		System.out.println(modelMap.toString());
		System.out.println(aaa);
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "auth/joinForm";
	}
}
