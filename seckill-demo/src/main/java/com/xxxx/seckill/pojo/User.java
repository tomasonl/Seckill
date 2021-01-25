package com.xxxx.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo
 * @since 2021-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id，手机号码")
    private Long id;

    private String nickname;

    @ApiModelProperty(value = "Md5加密 两次")
    private String password;

    @ApiModelProperty(value = " 加盐")
    private String slat;

    @ApiModelProperty(value = "头像")
    private String head;

    @ApiModelProperty(value = "注册时间")
    private Date registerDate;

    private Date lastLoginDate;

    @ApiModelProperty(value = "登录次数")
    private Integer loginCount;


}
