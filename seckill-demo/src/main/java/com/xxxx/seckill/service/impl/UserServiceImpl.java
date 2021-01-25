package com.xxxx.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.seckill.Exception.GlobalException;
import com.xxxx.seckill.mapper.UserMapper;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.util.CookieUtil;
import com.xxxx.seckill.util.Md5Util;
import com.xxxx.seckill.util.UUIDUtil;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import com.xxxx.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo
 * @since 2021-01-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        User user = userMapper.selectById(mobile);
        if(user==null){
//            return RespBean.error(RespBeanEnum.LOGINVO_ERROR); 定义了全局异常就可以如下
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }
        if(!Md5Util.fromPassToDBPass(password,user.getSlat()).equals(user.getPassword())){
            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
        }
        //生成Cookies
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user:"+ticket,user);
        //使用redis就部放到Session了：request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket", ticket);
        return RespBean.success();
    }
    //根据cookies获取用户
    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if(StringUtils.isEmpty(userTicket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if(user!= null){
            CookieUtil.setCookie(request,response,"UserTicket",userTicket);
        }
        return user;
    }

//    //根据cookies获取用户
//    @Override
//    public User getUserTicket(String userTicket) {
//        return null;
//    }
}
