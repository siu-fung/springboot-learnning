package cn.jbinfo.learning.springboot.system.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;

import cn.hutool.core.util.StrUtil;
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
	
	@GetMapping("/foreach")
	public void foreach(){
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.lambda().like(User::getUserName, 9);
		userService.list(wrapper)
		.stream().limit(10)
		.sorted(Comparator.comparing(User::getId).reversed())
		.map(user->user.getUserName())
		.forEach(user->{
			log.info("{}",user);
		});
	}
	
	@GetMapping("/limit")
	public void limit() {
		userService.list().stream().limit(15).collect(Collectors.toList()).forEach(str->{
			log.info("{}",str);
		});;
	}
	
	@GetMapping("/sorted")
	public void sorted() {
		//正序
		userService.list().stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList()).forEach(user->{
			log.info("{}",user.getUserName());
		});;
		//倒序
		userService.list().stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList()).forEach(user->{
			log.info("{}",user.getUserName());
		});;
	}
	
	@GetMapping("/map")
	public void map() {
		//Guava JDK的强化
		userService.list().stream().map(User::getId).collect(Collectors.toList()).forEach(str->{
			log.info("{}",str);
		});;
	}
	
	@GetMapping("/filter")
	public void filter() {
		//Hutool 通用工具类
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.lambda().like(User::getUserName, 9);
		userService.list(wrapper).stream().filter(user->(user.getId() >= 980 && StrUtil.isNotBlank(user.getUserName()))).forEach(user->{
			log.info("{}-{}",user.getId(),user.getUserName());
		});
	}
	
	@GetMapping("/dup")
	public void dup() {
		//userService.list().stream().distinct();
		userService.list().stream()
		.collect(
				Collectors.collectingAndThen(
						Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(User::getUserName))), 
						ArrayList<User>::new)).stream().sorted(Comparator.comparing(User::getId).reversed()).limit(200).forEach(user->{
							log.info("{}",user);
						});;
		List<String> list = Lists.newArrayList("1,2,3,4");
		System.out.println(list);
		
	}
	

}
