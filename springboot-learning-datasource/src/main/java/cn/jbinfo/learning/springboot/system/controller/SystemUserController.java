package cn.jbinfo.learning.springboot.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api
public class SystemUserController {
	
	@GetMapping("/index")
	public String index(){
		return "this is a index";
	}
	
}
