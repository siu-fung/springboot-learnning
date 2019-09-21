package cn.jbinfo.learning.springboot.system.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.jbinfo.learning.springboot.system.entity.User;

@Mapper
public interface SystemUserDao extends BaseMapper<User> {
	
}
