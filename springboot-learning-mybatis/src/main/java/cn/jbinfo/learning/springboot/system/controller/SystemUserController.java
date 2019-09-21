package cn.jbinfo.learning.springboot.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jbinfo.learning.springboot.system.dao.SystemUserDao;
import cn.jbinfo.learning.springboot.system.entity.User;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@Api
@AllArgsConstructor
public class SystemUserController {
	
//	@Autowired
//	private SystemUserDao userDao;
	
	private final SystemUserDao userDao;	
	

	@GetMapping("/index")
	public String index() {
		return "this is a index";
	}
	
	@GetMapping("/getById")
	public User getById(@RequestParam(name="id",required=true) int id) {
		return userDao.getById(id);
	}
	
	@GetMapping("/findAll")
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	//id 更改自增 主键
	@GetMapping("/add")
	public void add() {
		User user = new User();
		user.setUserName("mybatis test");
		user.setPassword("mybatis test");
		userDao.insert(user);
	}

	

}
