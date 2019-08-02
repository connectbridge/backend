package com.bridge.api.mapper;

import java.util.List;

import com.bridge.api.dto.Member;

public interface MemberMapper {
	public List<Member> getAll() throws Exception;
}
