package com.abc.account.controller;
/**
 * 登录controller
 */

import com.abc.account.pojo.User;
import com.abc.account.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //      进入登录页面
    @RequestMapping("/loginHtml")
    public String hello() {
        return "userLogin";
    }

    //    登录验证
    @ResponseBody
    @RequestMapping("/userLogin")
    public String userLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        if (StringUtils.isBlank(username)) {
            return "用户名不能为空";
        }

        if (StringUtils.isBlank(password)) {
            return "用户密码不能为空";
        }

        User user = userService.login(username, password);

        if (user != null) {
            System.out.println(user);
            request.getSession().setAttribute("user_session", user);
            return "登录成功";
        }
        return "登陆失败";
    }

    //  注册新用户页面
    @RequestMapping("/registerpage")
    public String userRegisterpage() {
        return "register";
    }

    //    新注册用户交易
    @ResponseBody
    @RequestMapping("/userRegister")
    public String userRegister(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            @RequestParam("job") String job,
            @RequestParam("password") String password,
            HttpServletRequest request) {

        User user = new User();
        if (StringUtils.isBlank(username)) {
            return "用户名不能为空";
        }

        if (StringUtils.isBlank(job)) {
            return "工作简介不能为空";
        }

        if (StringUtils.isBlank(password)) {
            return "用户密码不能为空";
        }

        user.setAge(age);
        user.setJob(job);
        user.setName(username);
        user.setPassword(password);
        int i = userService.addUser(user);
        if (i == 1) {
            return "注册成功";
        }
        return "注册失败";
    }
}
