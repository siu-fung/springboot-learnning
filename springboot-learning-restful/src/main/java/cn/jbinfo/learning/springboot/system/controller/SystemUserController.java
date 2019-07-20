package cn.jbinfo.learning.springboot.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemUserController {
	
	@GetMapping("/index")
	public String index(){
		return "this is a index";
	}
	
}
