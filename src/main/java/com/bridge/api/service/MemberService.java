package com.bridge.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridge.api.dto.Member;
import com.bridge.api.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;

	public List<Member> getAll() throws Exception {
		return memberMapper.getAll();
	}
}
