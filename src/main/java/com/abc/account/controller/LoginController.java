package com.abc.account.controller;
/**
 * 登录controller
 */

import com.abc.account.pojo.FamilyPosition;
import com.abc.account.pojo.Kind;
import com.abc.account.pojo.User;
import com.abc.account.service.UserService;
import com.abc.account.util.MailUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
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
import java.util.ArrayList;
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
        user1.setMails(username);
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


    //  完善用户信息页面
    @RequestMapping("/fullinformationpage")
    public String fullinformationpage() {
        return "user/information";
    }

    //    新注册用户交易
    @RequestMapping("/userRegister")
    @ResponseBody
    public int userRegister(
            @RequestParam("mails") String mails,
            @RequestParam("password") String password,
            HttpServletRequest request) {

        User user = new User();
        int flag = 0;
        user.setMails(mails);
        user.setPassword(password);
//        user.setName("");
//        user.setPosition("");
//        user.setPassword("");
//        User user1 = userService.login1(user);

        int i = userService.addUser(user);
        if (i == 1) {
            flag = 1;
            request.getSession().setAttribute("email_session", mails);
            logger.info(this.getClass() + "注册成功！");
        } else {
            flag = 0;
            logger.info(this.getClass() + "注册失败！");
        }
        return flag;

    }

    //    完善信息交易
    @RequestMapping("/allinformation")
    @ResponseBody
    public int allinformation(
            @RequestParam("username") String username,
            @RequestParam("userstatus") String userstatus,

            HttpServletRequest request) {

        User user = new User();
        int flag = 0;
        String email_session = (String) request.getSession().getAttribute("email_session");
        if (StringUtils.isBlank(email_session)) {
            flag = -1;
        } else {
            user.setMails(email_session);
            user.setPosition(userstatus);
            user.setName(username);
//        user.setName("");
//        user.setPosition("");
//        user.setPassword("");
//        User user1 = userService.login1(user);

            int i = userService.modifyInformation(user);
            if (i == 1) {
                flag = 1;
                logger.info(this.getClass() + "完善信息成功！");
            } else {
                flag = 0;
                logger.info(this.getClass() + "完善信息失败！");
            }
        }


        return flag;

    }

    //   获取session
    @RequestMapping("/getemail_session")
    @ResponseBody
    public int getemail_session(
            HttpServletRequest request) {

        int flag = 0;
        String email_session = (String) request.getSession().getAttribute("email_session");
        if (StringUtils.isBlank(email_session)) {
            flag = -1;
        }


        return flag;

    }

    //   找回用户名
    @RequestMapping("/findUserName")
    @ResponseBody
    public int findUserName(
            @Param("email") String email,
            HttpServletRequest request) {

        int flag = 0;
        User user = new User();
        user.setMails(email);
        User user1 = userService.findUserName(user);
        if (null == user1) {
            flag = -2;
        } else {
            if (StringUtils.isBlank(user1.getName())) {
                flag = -1;
            } else {
                logger.info(user1.getName());
                MailUtil.sendMail(email, user1.getName());
            }
        }


        return flag;

    }

    //    查询所有家庭地位
    @RequestMapping("/findAllPosition")
    @ResponseBody
    public List<String> findAllPosition() {
        List<FamilyPosition> position = userService.findAllPosition();

        List<String> list = new ArrayList<>();
        for (FamilyPosition familyPosition : position) {

            list.add(familyPosition.getName());
            logger.info("name=" + familyPosition.getName());
        }
        return list;
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
            @RequestParam("email1") String email1,
            @RequestParam("password1") String password1) {
        int flag;
        User user = new User();
        user.setName(email1);
        user.setMails(email1);

        User user1 = userService.selectByNameOrEmail(user);
        if (null == user1) {
            flag = -2;
        } else {
            user.setPassword(password1);
            int i = userService.updPassword(user);
            if (i <= 0) {
                flag = -1;
            } else {
                flag = 1;
            }
        }
        return flag;

    }


    //通过姓名查询
    @RequestMapping("/findByName")
    @ResponseBody
    public int findByName(@RequestParam("username") String username) {
        int flag;
        try {
            User user = new User();
            user.setName(username);
            User user1 = userService.selectByName(user);
            if (user1 != null) {
                flag = -1;
                logger.info(this.getClass() + "该用户 [" + user1.getName() + "] 存在");
                return flag;
            }
            logger.info(this.getClass() + "该用户 [" + username + "] 不存在");
            return 0;
        } catch (Exception e) {
            logger.error("错误原因" + e.getCause());
            logger.error("错误信息" + e.getMessage());
            return 999;
        }

    }

    //通过邮箱查询
    @RequestMapping("/findByEmail")
    @ResponseBody
    public int findByEmail(@RequestParam("mails") String mails) {
        int flag;
        try {
            User user = new User();
            user.setMails(mails);
            User user1 = userService.selectByEmail(user);
            if (user1 != null) {
                flag = -1;
                logger.info(this.getClass() + "该邮箱 [" + user1.getMails() + "] 已注册");
                return flag;
            }
            logger.info(this.getClass() + "该邮箱 [" + mails + "] 可用");
            return 0;
        } catch (Exception e) {
            logger.error("错误原因" + e.getCause());
            logger.error("错误信息" + e.getMessage());
            return 999;
        }

    }

    //通过姓名或者邮箱查询
    @RequestMapping("/findByNameOrEmail")
    @ResponseBody
    public int findByNameOrEmail(@RequestParam("username") String username) {
        int flag;
        try {
            User user = new User();
            user.setName(username);
            user.setMails(username);
            User user1 = userService.selectByNameOrEmail(user);
            if (user1 != null) {
                flag = -1;
                logger.info(this.getClass() + "该用户存在");
                return flag;
            }
            logger.info(this.getClass() + "该用户不存在");
            return 0;
        } catch (Exception e) {
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

    //    获取邮箱验证码
    @ResponseBody
    @RequestMapping("/getIcode")
    public String getIcode(
            HttpServletRequest request,
            @Param("mails") String mails) {

        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        logger.info("生成的验证码=" + random);
        MailUtil.sendMail(mails, random);
        request.getSession().setAttribute("icode", random);
        return random;
    }

}
