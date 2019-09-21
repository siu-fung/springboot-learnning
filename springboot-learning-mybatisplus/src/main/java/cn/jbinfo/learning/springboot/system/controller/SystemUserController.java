package cn.jbinfo.learning.springboot.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import cn.jbinfo.learning.springboot.system.dao.SystemUserDao;
import cn.jbinfo.learning.springboot.system.entity.User;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@Api
@AllArgsConstructor
public class SystemUserController {
	
	private final SystemUserDao userDao;

	@GetMapping("/index")
	public String index() {
		return "this is a index";
	}
	
	@GetMapping("/getById")
	public User getById(@RequestParam(name="id",required=true) int id) {
		return userDao.selectById(id);
	}
	
	@GetMapping("/findAll")
	public List<User> findAll() {
		return userDao.selectList(Wrappers.query(new User()));
	}
	
	@GetMapping("/add")
	public void add() {
		User user = new User();
		user.setUserName("mybatis ceshi1");
		user.setPassword("mybatis ceshi1");
		userDao.insert(user);
	}

}
