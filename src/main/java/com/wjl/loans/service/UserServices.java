package com.wjl.loans.service;

import com.wjl.loans.entity.User;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/16 13:00
 * @project: ${ProjectNAME}
 * @description 不写点什么？
 */
public interface UserServices {
    User register(User user);

    User login(User user);

    User update(User user);

}
