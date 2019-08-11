package com.bridge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BridgeController {
	@RequestMapping("/p/{memberId}")
	public String hello(@PathVariable("memberId") String memberId, ModelMap modelMap) {
		modelMap.addAttribute("memberId", memberId);
		return "main";
	}
}