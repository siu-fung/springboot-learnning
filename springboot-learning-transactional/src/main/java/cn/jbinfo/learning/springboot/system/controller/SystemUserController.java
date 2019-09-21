package cn.jbinfo.learning.springboot.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import cn.jbinfo.learning.springboot.system.entity.User;
import cn.jbinfo.learning.springboot.system.service.ISystemUserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api
@AllArgsConstructor
@Slf4j
public class SystemUserController {
	
	private final ISystemUserService userService;

	@GetMapping("/index")
	public String index() {
		return "this is a index";
	}
	
	@GetMapping("/getById")
	public User getById(@RequestParam(name="id",required=true) int id) {
		return userService.getById(id);
	}
	
	@GetMapping("/findAll")
	public List<User> findAll() {
		return userService.list(Wrappers.query(new User()));
	}
	
	@GetMapping("/add")
	public void add() {
		User user = new User();
		user.setUserName("mybatis ceshi1");
		user.setPassword("mybatis ceshi1");
		userService.save(user);
	}
	
	@GetMapping("/update/{id}")
	public void updateById(@PathVariable("id") Integer id) {
		log.info("param id is:{}",id);
		User user = new User();
		user.setId(id);
		userService.updateById(user);
	}

}
