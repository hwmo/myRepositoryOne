package com.mtest.ctr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public void test(String username, String password, HttpServletRequest req, HttpServletResponse res){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(username);
		System.out.println(password);
		map.put("username", username);
		map.put("password", password);
		try {
			res.getWriter().print(JSONObject.fromObject(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
