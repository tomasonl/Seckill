package com.xxxx.seckill.util;

import java.util.UUID;

/*
 *@program:seckill-demo
 *@author: Tomasonlee
 *@Time: 2021/1/19  10:06
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
