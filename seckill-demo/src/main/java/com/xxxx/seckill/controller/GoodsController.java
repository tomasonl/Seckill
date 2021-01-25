package com.xxxx.seckill.controller;

import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *@program:seckill-demo
 *@author: Tomasonlee
 *@Time: 2021/1/19  11:05
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/toList")
    public String toList(Model model,User user) {
//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
//        // User user = (User) session.getAttribute(ticket);
//        User user = userService.getUserByCookie(ticket, request, response);
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
