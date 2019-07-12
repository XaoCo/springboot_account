package com.abc.account.controller;

import com.abc.account.pojo.InAndOut;
import com.abc.account.pojo.User;
import com.abc.account.service.InAndOutService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * package: com.abc.account.controller
 * auther： abc
 * date: 2019/7/12 13:44
 * introduce: TODO
 */
@Controller
@RequestMapping("/record")
public class InAndOutController {

    @Autowired
    private InAndOutService inAndOutService;

    //    查询当前用户的收支记录
    @RequestMapping("/selRecord")
    public void selRecord(
            Model model,
            HttpServletRequest request) {
        User user_session = (User) request.getSession().getAttribute("user_session");
        List<InAndOut> inAndOuts = inAndOutService.selRecord(user_session.getName());
        model.addAttribute("inAndOuts", inAndOuts);
    }

    //    查询所有用户的收支记录
    @RequestMapping("/selAllRecord")
    public void selAllRecord(
            Model model,
            HttpServletRequest request) {
//        User user_session = (User) request.getSession().getAttribute("user_session");

        List<InAndOut> inAndOuts = inAndOutService.selAllRecord();
        model.addAttribute("inAndOuts", inAndOuts);
    }

    //    增添一条记录页面
    @RequestMapping("/addRecordPage")
    public String addRecordPage() {
        return "account/addrecordpage";
    }

    //     增添一条记录
    @RequestMapping("/addRecord")
    public String addRecord(
            @RequestParam("kindName") String kindName,
            @RequestParam("flag") int flag,
            @RequestParam("charge") BigDecimal charge,
            String desc,
            HttpServletRequest request) {


        if (StringUtils.isBlank("kindName")) {
            return "消费类别不能为空";
        }
//        获取session
        User user_session = (User) request.getSession().getAttribute("user_session");

        InAndOut inAndOut = new InAndOut();
        inAndOut.setU_name(user_session.getName());
        inAndOut.setK_name(kindName);
        inAndOut.setFlag(flag);
        inAndOut.setDesc(desc);
        inAndOut.setCharge(charge);
        int i = inAndOutService.addRecord(inAndOut);
        if (i <= 0) {
            return "新增记录失败";
        } else {
            return "account/allrecordspage";
        }
    }

    //    修改一条记录的页面
    @RequestMapping("/updRecordPage")
    public String updRecordPage() {
        return "account/updrecordpage";
    }

    //    修改一条记录
    @RequestMapping("/updRecord")
    public String updRecord(
            @RequestParam("id") int id,
            @RequestParam("kindName") String kindName,
            @RequestParam("flag") int flag,
            @RequestParam("charge") BigDecimal charge,
            String desc,
            HttpServletRequest request) {

        if (StringUtils.isBlank("kindName")) {
            return "消费类别不能为空";
        }
//        获取session
        User user_session = (User) request.getSession().getAttribute("user_session");

        InAndOut inAndOut = new InAndOut();
        inAndOut.setId(id);
        inAndOut.setU_name(user_session.getName());
        inAndOut.setK_name(kindName);
        inAndOut.setFlag(flag);
        inAndOut.setDesc(desc);
        inAndOut.setCharge(charge);

        int i = inAndOutService.updRecord(inAndOut);
        if (i <= 0) {
            return "修改记录失败！";
        } else {
            return "account/allrecordspage";
        }
    }

    //    删除一条记录
    @RequestMapping("/delRecord")
    public String delRecord(int id,
                            HttpServletRequest request) {
        int i = inAndOutService.delRecord(id);
        if (i <= 0) {
            return "删除记录失败！";
        } else {
            return "account/allrecordspage";
        }
    }
}
