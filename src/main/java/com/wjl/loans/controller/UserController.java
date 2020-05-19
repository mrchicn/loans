package com.wjl.loans.controller;

import com.wjl.loans.entity.User;
import com.wjl.loans.service.UserServices;
import com.wjl.loans.utils.BaseResult;
import com.wjl.loans.utils.MD5Util;
import com.wjl.loans.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/16 13:04
 * @project: ${ProjectNAME}
 * @description 不写点什么？
 */
@Slf4j //这里是lombok里面的注解
@RestController //=@Controller + @ResponseBody
@RequestMapping(value = "/api/user")
public class UserController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServices userServices;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResult register(User user) {
        log.info(user.getName() + "," + user.getAge() + "," + user.getPwd());
        user.setPwd(MD5Util.getmd5(user.getPwd()));
        User register = userServices.register(user);
        if (register.getStatus() > 0) {
            return ResultUtil.success(register.getMsg(), register);
        }
        return ResultUtil.error(user.getMsg(), null);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult<User> login(User user) {
        log.info(user.getName() + "," + user.getPwd());
        user.setPwd(MD5Util.getmd5(user.getPwd()));
        User login = userServices.login(user);
        if (login.getStatus() > 0) {
            return ResultUtil.success(login.getMsg(), login);
        }
        return ResultUtil.error(user.getMsg(), null);

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult<User> update(User user) {
        User update = userServices.update(user);
        if (update.getStatus() > 0) {
            return ResultUtil.success(update.getMsg(), update);
        }
        return ResultUtil.error(update.getMsg(), null);
    }
}