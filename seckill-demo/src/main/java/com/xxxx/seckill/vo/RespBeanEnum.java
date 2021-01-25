package com.xxxx.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/*
 *@program:seckill-demo
 *@author: Tomasonlee
 *@Time: 2021/1/18  16:45
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态码
    SUCCESS(200,"success"),
    ERROR(500,"服务端异常"),
    //登录模块
    SESSION_ERROR(500210,"session不存在或者已经失效"),
    LOGINVO_ERROR(500211,"用户名或者密码错误"),
    MOBILE_ERROR(500212,"手机号码格式错误"),
    BIND_ERROR(500213,"参数校验异常");
    private final Integer code;
    private final String message;
}
