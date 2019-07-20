package cn.jbinfo.learning.springboot.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.jbinfo.learning.springboot.system.entity.User;

@Repository
public interface UserResposity extends JpaRepository<User, Integer>  {

}
