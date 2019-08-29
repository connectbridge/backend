package com.bridge.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.bridge.api.dto.Member;
import com.bridge.api.service.MemberService;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	MemberService memberService;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String id = authentication.getName();
		String password = (String)authentication.getCredentials();

		System.out.println(id + " " + password);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("password", password);

		List<Member> member = new ArrayList<>();
		try {
			member = memberService.getMember(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(member.get(0).getsName());
		System.out.println(member.get(0).getsNickName());
//		// email에 맞는 user가 없거나 비밀번호가 맞지 않는 경우.
//		if (null == user || !user.getPassword().equals(password)) {
//			return null;
//		}

		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		// 로그인한 계정에게 권한 부여
//		if (user.isIsadmin()) {
//			grantedAuthorityList.add(new SimpleGrantedAuthority(Constant.ROLE_TYPE.ROLE_ADMIN.toString()));
//		} else {
//			grantedAuthorityList.add(new SimpleGrantedAuthority(Constant.ROLE_TYPE.ROLE_USER.toString()));
//		}

		//http://progtrend.blogspot.com/2018/07/spring-boot-security.html
		//UsernamePasswordAuthenticationToken

		// 로그인 성공시 로그인 사용자 정보 반환
		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}