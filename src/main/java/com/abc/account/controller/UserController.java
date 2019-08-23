package com.abc.account.controller;
/**
 * 登录controller
 */

import com.abc.account.pojo.User;
import com.abc.account.service.UserService;
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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //    实例化日志
    Logger logger = LoggerFactory.getLogger(this.getClass());


    //    用户修改密码页面
    @RequestMapping("/updpasswordpage")
    public String updPasswordPage() {
        return "user/updpasswordpage";
    }

    //    用户修改密码
    @ResponseBody
    @RequestMapping("/updpassword")
    public int updPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("passwordNew") String passwordNew,
            HttpServletRequest request) {

        User user = new User();
        user.setPassword(passwordNew);
        user.setName(username);
        //  判断该客户是否存在
        User user1 = userService.login1(user);

        int flag;
        if (user1 != null) {
            int i = userService.updPassword(user);
            System.out.println(i);
            if (i <= 0) {
                flag = -1;
                return flag;
            } else {
                flag = 0;
                return flag;
            }
        } else {
            flag = 1;
            return flag;
        }

    }

    //    删除用户
    @ResponseBody
    @RequestMapping("/delUser")
    public int delUser(
            @RequestParam("name") String name,
            HttpServletRequest request) {

//        User user_session = (User) request.getSession().getAttribute("user_session");
        int flag;

        int i = userService.delUser(name);
        if (i <= 0) {
            flag = -1;
            return flag;
        } else {
            flag = 0;
            return flag;
        }

    }

    //    查询所有用户信息
    @RequestMapping("/selAllUser")
    public String selAllUser(Model model) {
        List<User> allUser = userService.getAllUser();

        model.addAttribute("list", allUser);
        return "index";
    }


    //    展示首页
    @RequestMapping("/indexPage")
    public String indexPage() {
        return "/main/index.html";
    }

    //通过姓名查询
    @RequestMapping("/findByName")
    @ResponseBody
    public int findByName(@RequestParam("username") String username) {
        int flag;
        User user = new User();
        user.setName(username);
        User user1 = userService.login1(user);
        if (user1 != null) {
            flag = -1;
            logger.info(this.getClass() + "该用户存在" + user1.toString());
            return flag;
        }
        logger.info(this.getClass() + "该用户不存在");
        return 0;
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
