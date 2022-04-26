package com.inexture.MVCexa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/mvc")
	public String redirect() {
		return "viewpage";
	}
	
	@RequestMapping("/boot")
	public String redirect2() {
		return "viewpage2";
	}
}
