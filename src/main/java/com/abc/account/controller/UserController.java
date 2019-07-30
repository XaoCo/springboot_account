package com.abc.account.controller;
/**
 * 登录controller
 */

import com.abc.account.pojo.User;
import com.abc.account.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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
            Model model,
            HttpServletRequest request) {
        int flag = 0;
        if (StringUtils.isBlank(username)) {
            flag = -1;
            return flag;

        }

        if (StringUtils.isBlank(password)) {
            flag = -2;
            return flag;
        }


        User user1 = new User();
        user1.setName(username);
        user1.setPassword(password);

        User user2 = userService.login1(user1);
        if (user2 != null) {
            User user = userService.login(user1);

            if (user != null) {
                System.out.println(user);
                request.getSession().setAttribute("user_session", user);
                flag = 0;
                return flag;
            } else {

                flag = 1;
                return flag;
            }
        } else {
            flag = 2;
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
            } else {
                model.addAttribute("msg6", "注册失败，请核实！");
                flag = 0;
            }

        } else {
            model.addAttribute("msg5", "该姓名已经注册，请直接登录！");
            flag = -1;
        }
        return flag;

    }

    //    用户修改密码页面
    @RequestMapping("/updpasswordpage")
    public String updPasswordPage() {
        return "user/updpasswordpage";
    }

    //    用户修改密码
    @RequestMapping("/updpassword")
    public String updPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("passwordNew") String passwordNew,
            HttpServletRequest request) {

        User user = new User();
        user.setPassword(passwordNew);
        user.setName(username);
        //  判断该客户是否存在
        User user1 = userService.login1(user);

        if (user1 != null) {
            int i = userService.updPassword(user);
            System.out.println(i);
            if (i <= 0) {
                return "修改密码失败";
            } else {
                return "修改密码成功";
            }
        } else {
            return "未查到符合该条件的人员信息，请核实后再行修改！";
        }

    }

    //    删除用户
    @RequestMapping("/delUser")
    public String delUser(
            @RequestParam("name") String name,
            HttpServletRequest request) {

        User user_session = (User) request.getSession().getAttribute("user_session");

        int i = userService.delUser(name);
        if (i <= 0) {
            return ("用户删除失败");
        } else {
            return "用户删除成功";
        }

    }

    //    查询所有用户信息
    @RequestMapping("/selAllUser")
    public String selAllUser(Model model) {
        List<User> allUser = userService.getAllUser();

        model.addAttribute("list", allUser);
        return "index";
    }

    //    忘记密码或者找回密码页面
    @RequestMapping("/findPwdPage")
    public String findPwdPage() {
        return "user/findpwdpage";
    }

    //    忘记密码或者找回密码
    @RequestMapping("/findPwd")
    public String findPwd(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            Model model,
            HttpServletRequest request) {
        User user = new User();
        user.setName(userName);
        User user1 = userService.login1(user);
        if (user1 != null) {
            user1.setPassword(password);
            int i = userService.updPassword(user1);
            if (i <= 0) {
                model.addAttribute("msg4", "重置密码失败");
                return "forward:/user/findPwdPage";
            } else {
                model.addAttribute("msg3", "重置密码成功，请登录");
                return "forward:/user/loginHtml";
            }
        } else {
            model.addAttribute("msg5", "该姓名还未注册过，请先注册！");
            return "forward:/user/registerpage";
        }

    }

    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");

    /**
     * 利用正则表达式来判断字符串是否为数字
     */
    public static boolean checkStrIsNum02(String str) {
        String bigStr;
        try {
            /** 先将str转成BigDecimal，然后在转成String */
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            /** 如果转换数字失败，说明该str并非全部为数字 */

            return false;
        }
        Matcher isNum = NUMBER_PATTERN.matcher(str);
        if (!isNum.matches() || str.length() != 18) {
            return false;
        }
        return true;
    }

}
