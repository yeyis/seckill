package com.yeyi.seckill.utils;

import com.yeyi.seckill.entity.User;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: seckill-demo1
 * @BelongsPackage: com.yeyi.seckill.utils
 * @Author: yeyi
 * @CreateTime: 2022-05-25  23:00
 * @Description: 用户生成类
 * @Version: 1.0
 */
public class UserUtil {
    private static void createUser(int count) {
        List<User> users = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(18756299936L + i);
            user.setNickname("user" + i);
            user.setSalt("1a2b3c");
            user.setPassword(MD5Util.inputPassToDBPass("123456", user.getSalt()));
            users.add(user);
        }
        System.out.println("create users");
    }

}

