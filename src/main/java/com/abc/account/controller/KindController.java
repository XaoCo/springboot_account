package com.abc.account.controller;

import com.abc.account.pojo.Kind;
import com.abc.account.service.KindService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * package: com.abc.account.controller
 * auther： abc
 * date: 2019/7/12 10:00
 * introduce: 消费分类controller
 */
@Controller
@RequestMapping("/kind")
public class KindController {

    @Autowired
    private KindService kindService;

    //    查询所有种类
    @RequestMapping("/findAllKind")
    public void findAllKind(Model model) {
        List<Kind> allKind = kindService.findAllKind();

        model.addAttribute("allKind", allKind);
    }

    //    新增种类页面
    @RequestMapping("/addKindpage")
    public String addKindpage() {
        return "kind/addkindpage";
    }

    //    新增种类
    @RequestMapping("/addKind")
    public String addKind(
            @RequestParam("kindName") String kindName,
            HttpServletRequest request) {

        if (StringUtils.isBlank(kindName)) {
            return "种类名称不能为空";
        }

        Kind kind = kindService.findByName(kindName);
        if (kind == null) {
            int i = kindService.addKind(kindName);
            if (i <= 0) {

                return "新增种类失败，请检查！";
            } else {
                return "kind/allkindpage";
            }

        } else {
            return "该类别已经存在！";
        }


    }
//修改种类页面
    @RequestMapping("/updKindPage")
    public String updKindPage(){
        return "kind/updkindpage";
    }
    //    修改某一种类的名称
    @RequestMapping("/updKind")
    public String updKind(@RequestParam("id") int id,
                          @RequestParam("kindName") String kindName,
                          HttpServletRequest request) {
        int i = kindService.updKind(id, kindName);
        if (i <= 0) {
            return "修改信息失败";
        } else {
            return "kind/allkindpage";
        }

    }

    //    删除某一种类
    @RequestMapping("/delKind")
    public String delKind(@RequestParam("id") int id,
                          HttpServletRequest request) {
        int i = kindService.delKind(id);
        if (i <= 0) {
            return "删除种类失败";
        } else {
            return "kind/allkindpage";
        }
    }
}
