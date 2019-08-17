package com.bridge.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@Api(value = "Brdige", description = "브릿지")
@RequestMapping("/api")
public class bbridgeController {
	@Autowired
	MemberService memberService;

	@ApiOperation(value = "회원 목록")
	@GetMapping("/bridge/getMemberList")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "memberSeq", value = "회원번호", required = false, dataType = "Long", paramType = "query"),
		@ApiImplicitParam(name = "id", value = "아이디", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "email", value = "이메일", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "이름", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickName", value = "닉네임", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "birthDate", value = "생년월일", required = false, dataType = "String", paramType = "query")})
	public @ResponseBody List<Member> getMemberList(
			@RequestParam(value="memberSeq", required=false) Long memberSeq,
			@RequestParam(value="id", required=false) String id,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="nickName", required=false) String nickName,
			@RequestParam(value="birthDate", required=false) String birthDate) throws Exception {

		Map<String, Object> selectParam = new HashMap<String, Object>();
		if (memberSeq != null) selectParam.put("memberSeq", memberSeq);
		if (id != null) selectParam.put("id", id);
		if (email != null) selectParam.put("email", email);
		if (name != null) selectParam.put("name", name);
		if (nickName != null) selectParam.put("nickName", nickName);
		if (birthDate != null) selectParam.put("birthDate", birthDate);

		return memberService.getMember(selectParam);
	}

	@ApiOperation(value = "회원 생성")
	@PutMapping("/bridge/insertMember")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "아이디", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "email", value = "이메일", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "passWord", value = "비밀번호", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "이름", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickName", value = "닉네임", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "birthDate", value = "생년월일", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "sex", value = "성별", required = false, dataType = "int", paramType = "query")})
	public @ResponseBody Long insertMember(
			@RequestParam(value="id", required=true) String id,
			@RequestParam(value="email", required=true) String email,
			@RequestParam(value="passWord", required=false) String passWord,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="nickName", required=false) String nickName,
			@RequestParam(value="birthDate", required=false) String birthDate,
			@RequestParam(value="sex", required=false) int sex) throws Exception {

		Map<String, Object> selectParam = new HashMap<String, Object>();
		if (id != null) selectParam.put("id", id);
		if (email != null) selectParam.put("email", email);
		if (name != null) selectParam.put("name", name);
		if (nickName != null) selectParam.put("nickName", nickName);
		if (birthDate != null) selectParam.put("birthDate", birthDate);
		if (passWord != null) selectParam.put("passWord", passWord);
		if (sex < 0) selectParam.put("sex", sex);

		return memberService.insertMember(selectParam);
	}
}