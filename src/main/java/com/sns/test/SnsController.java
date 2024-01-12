package com.sns.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.post.mapper.SnsMapper;

@Controller
public class SnsController {
	
	@Autowired
	private SnsMapper snsMapper;
	
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "hello world!";
	}
	
	@GetMapping("/test2")
	@ResponseBody
	public Map<String, Object> test2(){
		Map<String, Object> result = new HashMap<>();
		result.put("aaa", 1);
		result.put("bbb", 2);
		result.put("ccc", 32);
		
		return result;
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	@GetMapping("/test4")
	@ResponseBody
	public List<Map<String,Object>> test4() {

		return snsMapper.selectUserList();
		
	}
}
