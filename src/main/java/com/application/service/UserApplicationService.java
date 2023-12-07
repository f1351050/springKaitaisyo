package com.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

	public Map<String,Integer> getGendarMap(){
		Map<String,Integer> gendarMap = new LinkedHashMap<>();
		gendarMap.put("男性", 1);
		gendarMap.put("女性", 2);
		return gendarMap;
	}
}
