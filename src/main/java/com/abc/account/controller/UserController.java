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
            @RequestParam("identityCard") String identityCard,
            HttpServletRequest request) {
        if (StringUtils.isBlank(username)) {
            return "用户名不能为空";
        }

        if (StringUtils.isBlank(password)) {
            return "用户密码不能为空";
        }
        if (StringUtils.isBlank(identityCard)) {
            return "身份证不能为空";
        }

        User user1 = new User();
        user1.setIdentityCard(identityCard);
        user1.setName(username);
        user1.setPassword(password);

        User user = userService.login(user1);

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
            @RequestParam("identityCard") String identityCard,
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
        user.setIdentityCard(identityCard);
        User user1 = userService.login(user);

        if(user1==null){
            int i = userService.addUser(user);
            if (i == 1) {
                return "注册成功";
            }
            return "注册失败";
        }else {
            return "该姓名和身份证已经注册，请核实信息再行注册！";
        }


    }
    //    用户修改密码页面
    @RequestMapping("/userupdatepage")
    public String updPasswordPage(){
        return "userupdatepage";
    }
    //    用户修改密码
    @ResponseBody
    @RequestMapping("/userupdate")
    public String updPassword(
            @RequestParam("username") String username,
            @RequestParam("identityCard") String identityCard,
            @RequestParam("password") String password,
            @RequestParam("passwordNew") String passwordNew,
            HttpServletRequest request) {

        User user = new User();
        user.setPassword(password);
        user.setName(username);
        user.setIdentityCard(identityCard);
        //  判断该客户是否存在
        User user1 = userService.login(user);

        if (user1 != null) {
            int i = userService.updPassword(user, passwordNew);
            System.out.println(i);
            if(i<=0){
                return "修改密码失败";
            }else {
                return "修改密码成功";
            }
        }else {
            return "未查到符合该条件的人员信息，请核实后再行修改！";
        }


//        User user_session = (User) request.getSession().getAttribute("user_session");


    }
}
