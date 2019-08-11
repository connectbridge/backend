package com.bridge.api.mapper;

import java.util.List;
import java.util.Map;

import com.bridge.api.dto.Member;

public interface MemberMapper {
	public List<Member> getAll() throws Exception;
	public List<Member> getMember(Map<String, Object> param) throws Exception;
	public List<Member> insertMember(Map<String, Object> param) throws Exception;
}
