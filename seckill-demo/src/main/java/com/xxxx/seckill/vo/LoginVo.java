package com.xxxx.seckill.vo;

import com.xxxx.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/*
 *@program:seckill-demo
 *@author: Tomasonlee
 *@Time: 2021/1/18  18:03
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min=32)
    private String password;
}
