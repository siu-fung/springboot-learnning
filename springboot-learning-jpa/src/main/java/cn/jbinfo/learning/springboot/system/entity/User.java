package cn.jbinfo.learning.springboot.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="t_user")
@Data
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@Column(length=32,name="user_name")
    private String userName;
	@Column(length=32,name="password")
    private String password;
	
}
