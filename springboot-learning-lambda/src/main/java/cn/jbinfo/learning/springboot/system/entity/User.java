package cn.jbinfo.learning.springboot.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data 
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@TableId(value = "id", type = IdType.AUTO)
    private Integer id;
	
	@TableField("user_name")
    private String userName;
	
	@TableField("password")
    private String password;
	
	@TableField(value = "CREATE_DATE",fill = FieldFill.INSERT)
    private Date createDate;
	
	@TableField(value = "UPDATE_DATE",fill = FieldFill.UPDATE)
    private Date updateDate;
	
}
