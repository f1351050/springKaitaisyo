package com.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	
	@Autowired
	private MessageSource messageSource;


	public Map<String,Integer> getGendarMap(Locale locale){
		Map<String,Integer> gendarMap = new LinkedHashMap<>();
		String male= messageSource.getMessage("male",null,locale);
		String female= messageSource.getMessage("female",null,locale);
		
		gendarMap.put(male, 1);
		gendarMap.put(female, 2);
		return gendarMap;
	}
}
