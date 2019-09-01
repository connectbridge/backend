package com.bridge.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
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

		// id,password 매칭되지 않는 경우
		if (member.isEmpty()) {
			throw new BadCredentialsException("아이디 또는 패스워드가 일치하지 않습니다.");
		}

		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 로그인 성공시 로그인 사용자 정보 반환
		return new UsernamePasswordAuthenticationToken(member.get(0), null, grantedAuthorityList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}