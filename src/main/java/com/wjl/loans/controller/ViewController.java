package com.wjl.loans.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/16 13:06
 * @project: ${ProjectNAME}
 * @description 不写点什么？
 */
@Slf4j
@Controller
@RequestMapping("/api/view")
public class ViewController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ViewController.class);

    @ResponseBody
    @RequestMapping("/login")
    public ModelAndView login() {
        log.info("视图跳转。。。");
        return new ModelAndView("login");
    }

    @ResponseBody
    @RequestMapping("/register")
    public ModelAndView register() {
        log.info("视图跳转。。。");
        return new ModelAndView("register");
    }
}