package com.wjl.loans.service.impl;

import com.wjl.loans.dao.UserDao;
import com.wjl.loans.entity.User;
import com.wjl.loans.service.UserServices;
import com.wjl.loans.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/16 13:01
 * @project: ${ProjectNAME}
 * @description 不写点什么？
 */
@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        User existUser = userDao.findUserNameByName(user.getName());
        try {
            if (existUser != null) {
                user.setMsg("用户名已存在！");
                user.setPwd("^_^！");
            } else {
                user.setPwd(MD5Util.getmd5(user.getPwd()));
                user.setCtime(new Date());
                userDao.regist(user);
                user.setMsg("注册成功");
                user.setStatus(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
            user.setMsg(e.getMessage());
        }
        return user;
    }

    @Override
    public User login(User user) {
        user.setPwd(MD5Util.getmd5(user.getPwd()));
        User userId = userDao.login(user);
        try {
            if (userId == null) {
                user.setMsg("用户名或密码不正确");
                user.setStatus(-316);
                return user;
            } else {
                userId.setMsg("登录成功！");
                userId.setSuccess(true);
                userId.setStatus(200);
            }
        } catch (Exception e) {
            e.getStackTrace();
            user.setMsg(e.getMessage());
        }
        return userId;
    }

    @Override
    public User update(User user) {
        Long update = userDao.update(user);
        try {
            if (update < 0) {
                user.setMsg("更新失败！");
                user.setStatus(-316);
            } else {
                user.setMsg("更新成功！");
                user.setSuccess(true);
                user.setStatus(200);
            }
        } catch (Exception e) {
            e.getStackTrace();
            user.setMsg(e.getMessage());
        }
        return user;
    }
}