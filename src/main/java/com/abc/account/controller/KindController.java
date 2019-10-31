package com.abc.account.controller;

import com.abc.account.pojo.Kind;
import com.abc.account.service.KindService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //    查询所有消费种类
    @RequestMapping("/findAlloutKind")
    @ResponseBody
    public List<String> findAlloutKind() {
        String flag = "0";
        List<Kind> allKind = kindService.findAllKind(flag);
        List<String> list = new ArrayList<>();
        for (Kind kind : allKind) {

            list.add(kind.getName());
            logger.info("name=" + kind.getName());
        }
        return list;
    }

    //    查询所有收入种类
    @RequestMapping("/findAllinKind")
    @ResponseBody
    public List<String> findAllinKind() {
        String flag = "1";
        List<Kind> allKind = kindService.findAllKind(flag);

        List<String> list = new ArrayList<>();
        for (Kind kind : allKind) {

            list.add(kind.getName());
            logger.info("name=" + kind.getName());
        }
        return list;
    }

    //    查询所有预留开支种类
    @RequestMapping("/findAllpreKind")
    @ResponseBody
    public List<String> findAllPreKind() {
        String flag = "3";
        List<Kind> allKind = kindService.findAllKind(flag);

        List<String> list = new ArrayList<>();
        for (Kind kind : allKind) {

            list.add(kind.getName());
            logger.info("name=" + kind.getName());
        }
        return list;
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
    public String updKindPage() {
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
