package com.bridge.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridge.api.dto.ResponseResult;
import com.bridge.api.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Member", description = "회원")
@RequestMapping("/api")
public class MemberController {
	@Autowired
	MemberService memberService;

	@ApiOperation(value = "회원 목록")
	@GetMapping("/member/getMemberList")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "isCount", value = "count", required = false, dataType = "Boolean", paramType = "query"),
		@ApiImplicitParam(name = "memberSeq", value = "회원번호", required = false, dataType = "Long", paramType = "query"),
		@ApiImplicitParam(name = "id", value = "아이디", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "email", value = "이메일", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "이름", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickName", value = "닉네임", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "birthDate", value = "생년월일", required = false, dataType = "String", paramType = "query")})
	public ResponseResult getMemberList(
			@RequestParam(value="isCount", required=false, defaultValue="false") Boolean isCount,
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

		ResponseResult responseResult = new ResponseResult();
		if (isCount == true) {
			responseResult.setMessage("<select> member Count");
			responseResult.setResult(memberService.getCountMember(selectParam));
		} else {
			responseResult.setMessage("<select> member Data List");
			responseResult.setResult(memberService.getMember(selectParam));
		}
		return responseResult;
	}

	@ApiOperation(value = "회원 생성")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "데이터가 없을 경우", response = Long.class),
			@ApiResponse(code = 400, message = "필수 값 누락 및 데이터 타입이 맞지 않는 경우"),
			@ApiResponse(code = 500, message = "서버 오류 발생") })
	@PutMapping("/member/insertMember")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "아이디", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "email", value = "이메일", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "비밀번호", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name", value = "이름", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickName", value = "닉네임", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "birthDate", value = "생년월일", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "sex", value = "성별", required = false, dataType = "int", paramType = "query")})
	public ResponseResult insertMember(
			@RequestParam(value="id", required=true) String id,
			@RequestParam(value="email", required=true) String email,
			@RequestParam(value="password", required=true) String password,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="nickName", required=false) String nickName,
			@RequestParam(value="birthDate", required=false) String birthDate,
			@RequestParam(value="sex", required=false, defaultValue="0") int sex) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		if (id != null) param.put("id", id);
		if (email != null) param.put("email", email);
		if (name != null) param.put("name", name);
		if (nickName != null) param.put("nickName", nickName);
		if (birthDate != null) param.put("birthDate", birthDate);
		if (password != null) param.put("password", password);
		if (sex < 0) param.put("sex", sex);

		ResponseResult responseResult = new ResponseResult();
		responseResult.setMessage("<insert> member");
		try {
			responseResult.setResult(memberService.insertMember(param));
		} catch (Exception e) {
//			ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
//			HttpServletResponse response = servletContainer.getResponse();
//			System.out.println(response.getStatus());
//			responseResult.setStatus(response.getStatus());
		}
		return responseResult;
	}
}