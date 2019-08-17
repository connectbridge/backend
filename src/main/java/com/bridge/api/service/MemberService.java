package com.bridge.api.service;

import java.util.List;
import java.util.Map;

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

	public Long getCountMember(Map<String, Object> param) throws Exception {
		return memberMapper.getCountMember(param);
	}

	public List<Member> getMember(Map<String, Object> param) throws Exception {
		return memberMapper.getMember(param);
	}

	public Long insertMember(Map<String, Object> param) throws Exception {
		return memberMapper.insertMember(param);
	}
}
