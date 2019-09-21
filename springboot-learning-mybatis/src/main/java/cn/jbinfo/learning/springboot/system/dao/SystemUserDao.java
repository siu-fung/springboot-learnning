package cn.jbinfo.learning.springboot.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.jbinfo.learning.springboot.system.entity.User;

@Mapper
public interface SystemUserDao {
	
	public User getById(int id);
	
	List<User> findAll();
	
	public void insert(User user);
	
}
