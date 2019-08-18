package com.bridge.api.util;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> originalResult = super.getErrorAttributes(webRequest, includeStackTrace);

		// springboot error json custom
		Map<String, Object> customResult = new LinkedHashMap<String, Object>();
		customResult.put("status", originalResult.get("status"));
		customResult.put("desc", originalResult.get("error"));
		customResult.put("message", originalResult.get("message"));
		customResult.put("check", false);
		customResult.put("date", new Date(System.currentTimeMillis()));
		customResult.put("time", new Time(System.currentTimeMillis()));
		customResult.put("result", null);
		return customResult;
	}
}
