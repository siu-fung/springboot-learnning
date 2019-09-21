package cn.jbinfo.learning.springboot.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.jbinfo.learning.springboot.system.dao.SystemUserDao;
import cn.jbinfo.learning.springboot.system.entity.User;
import cn.jbinfo.learning.springboot.system.service.ISystemUserService;

@Service
@Transactional(readOnly=true)
public class SystemUserImpl 
extends ServiceImpl<SystemUserDao, User> 
implements ISystemUserService{

}
