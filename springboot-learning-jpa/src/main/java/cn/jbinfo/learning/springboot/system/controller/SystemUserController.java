package cn.jbinfo.learning.springboot.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jbinfo.learning.springboot.system.dao.UserResposity;
import cn.jbinfo.learning.springboot.system.entity.User;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@Api
public class SystemUserController {
	
	@Autowired
	private UserResposity userReposity;
	
	@GetMapping("/index")
	public String index(){
		return "this is a index";
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userReposity.findAll();
	}
	
	@GetMapping("/initData")
	public Result<User> initData(
			@RequestParam(name="size", required=true) Integer size) {
		if(size != null){
			User user = null;
			List<User> userList = new ArrayList<>();
			Optional<User>  maxUser = userReposity.findAll()
					.stream()
					.max((s1,s2)->Integer.compare(s1.getId(), s2.getId()));
			int maxId = maxUser.get().getId() + 1;
			for (int i = 0; i < size; i++) {
				user = new User();
				user.setId(maxId + i);
				user.setUserName("username_"+user.getId());
				user.setPassword("password_"+user.getId());
				userList.add(user);
			}
			userReposity.saveAll(userList);
		}
		return new Result<User>(true,null);
		
		
	}
	
	@Data
	@AllArgsConstructor
	class Result<T> {
		private boolean success;
		private T data;
	}
	
	
	
	
}
