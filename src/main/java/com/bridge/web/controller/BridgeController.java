package com.bridge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BridgeController {
	@RequestMapping("/main")
	public String hello() {
		return "main";
	}
}
