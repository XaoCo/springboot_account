package com.abc.account.controller;
/**
 * 登录controller
 */

import com.abc.account.pojo.User;
import com.abc.account.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    //    实例化日志
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //      进入登录页面
    @RequestMapping("/loginHtml")
    public String hello() {
        return "user/userLogin";
    }

    //    登录验证
    @RequestMapping("/userLogin")
    @ResponseBody
    public int userLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        int flag = 0;
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            flag = -1;

            logger.error(this.getClass() + "用户名或者密码为空，登录失败！");
            return flag;

        }

        User user1 = new User();
        user1.setName(username);
        user1.setPassword(password);

        User user = userService.login(user1);

        if (user != null) {
            System.out.println(user);
            request.getSession().setAttribute("user_session", user);
            flag = 0;
            logger.info(this.getClass() + "登录成功!");
            return flag;
        } else {

            flag = 1;
            logger.error(this.getClass() + "登录失败！");
            return flag;
        }

    }

    //  注册新用户页面
    @RequestMapping("/registerpage")
    public String userRegisterpage() {
        return "user/register";
    }

    //    新注册用户交易
    @RequestMapping("/userRegister")
    @ResponseBody
    public int userRegister(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            @RequestParam("job") String job,
            @RequestParam("password") String password,
            Model model,
            HttpServletRequest request) {

        User user = new User();
        int flag = 0;

        user.setAge(age);
        user.setJob(job);
        user.setName(username);
        user.setPassword(password);
        User user1 = userService.login1(user);

        if (user1 == null) {
            int i = userService.addUser(user);
            if (i == 1) {
                model.addAttribute("msg4", "注册成功，请登录！");
                flag = 1;
                logger.info(this.getClass() + "注册成功！");
            } else {
                model.addAttribute("msg6", "注册失败，请核实！");
                flag = 0;
                logger.info(this.getClass() + "注册失败！");
            }

        } else {
            model.addAttribute("msg5", "该姓名已经注册，请直接登录！");
            flag = -1;
            logger.info(this.getClass() + "该姓名已经注册");
        }
        return flag;

    }


    //    忘记密码或者找回密码页面
    @RequestMapping("/findPwdPage")
    public String findPwdPage() {
        return "user/findpwdpage";
    }

    //    忘记密码或者找回密码
    @RequestMapping("/findPwd")
    @ResponseBody
    public int findPwd(
            @RequestParam("username") String userName,
            @RequestParam("password") String password) {
        int flag;
        User user = new User();
        if (StringUtils.isBlank(userName)) {
            flag = -2;
            return flag;
        }
        if (StringUtils.isBlank(password)) {
            flag = -2;
            return flag;
        }
        user.setName(userName);
        User user1 = userService.login1(user);

        if (user1 != null) {
            user1.setPassword(password);
            int i = userService.updPassword(user1);
            if (i <= 0) {
                flag = -1;
                return flag;
            } else {
//                model.addAttribute("msg3", "重置密码成功，请登录");
//                return "forward:/user/loginHtml";
                flag = 1;
                return flag;
            }
        } else {
//            model.addAttribute("msg5", "该姓名还未注册过，请先注册！");
//            return "forward:/user/registerpage";
            flag = 0;
            return flag;
        }

    }


    //通过姓名查询
    @RequestMapping("/findByName")
    @ResponseBody
    public int findByName(@RequestParam("username") String username) {
        int flag;
        try {
            User user = new User();
            user.setName(username);
            User user1 = userService.login1(user);
            if (user1 != null) {
                flag = -1;
                logger.info(this.getClass() + "该用户 [" + user1.getName() + "] 存在");
                return flag;
            }
            logger.info(this.getClass() + "该用户 [" + username + "] 不存在");
            return 0;
        } catch (Exception e) {
//            logger.error("sqlState"+e.getSQLState());
//            logger.error("错误码"+e.getErrorCode());
            logger.error("错误原因" + e.getCause());
            logger.error("错误信息" + e.getMessage());
            return 999;
        }

    }

    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");

    /**
     * 利用正则表达式来判断字符串是否为数字
     */
//    public static boolean checkStrIsNum02(String str) {
//        String bigStr;
//        try {
//            /** 先将str转成BigDecimal，然后在转成String */
//            bigStr = new BigDecimal(str).toString();
//        } catch (Exception e) {
//            /** 如果转换数字失败，说明该str并非全部为数字 */
//
//            return false;
//        }
//        Matcher isNum = NUMBER_PATTERN.matcher(str);
//        if (!isNum.matches() || str.length() != 18) {
//            return false;
//        }
//        return true;
//    }

    //    退出登录
//    @ResponseBody
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().setAttribute("user_session", null);
        return "forward:/user/loginHtml";
    }

}
