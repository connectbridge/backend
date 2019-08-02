package com.bridge.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridge.api.dto.Member;
import com.bridge.api.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "main", description = "Main Controller")
@RequestMapping("/api")
public class MainController {
	@Autowired
	MemberService memberService;

	@ApiOperation(value = "회원 목록")
	@GetMapping("/member/getMemberList")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberSeq", value = "회원번호", required = false, dataType = "Long", paramType = "query"),
		@ApiImplicitParam(name = "id", value = "아이디", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "email", value = "이메일", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "이름", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickName", value = "닉네임", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "birthDate", value = "생년월일", required = false, dataType = "String", paramType = "query")})
	public @ResponseBody List<Member> query(
			@RequestParam(value="memberSeq", required=false) Long memberSeq,
			@RequestParam(value="id", required=false) String id,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="nickName", required=false) String nickName,
			@RequestParam(value="birthDate", required=false) String birthDate) throws Exception {
		return memberService.getAll();
	}
}