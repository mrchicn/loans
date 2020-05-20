package com.wjl.loans.service;

import com.wjl.loans.entity.User;

import java.util.List;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/16 13:00
 * @project: ${ProjectNAME}
 * @description 不写点什么？
 */
public interface UserServices {

   // 注册
    User register(User user);
    // 登录
    User login(User user);
    // 更新
    User update(User user);
    // 返回所有用户
    List<User>findAllUser();

}
