package com.abc.account.controller;

import com.abc.account.pojo.InAndOut;
import com.abc.account.pojo.User;
import com.abc.account.service.InAndOutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //    实例化日志
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //    查询当前用户的收支记录
    @RequestMapping("/selRecord")
    @ResponseBody
    public List<InAndOut> selRecord(
            int flag,
            HttpServletRequest request) {
        InAndOut inAndOut = new InAndOut();
        User user_session = (User) request.getSession().getAttribute("user_session");
//        int flag = 0;
        logger.info("flag="+flag);
        inAndOut.setFlag(flag);
        inAndOut.setU_name(user_session.getName());

        List<InAndOut> inAndOuts = inAndOutService.selRecord(inAndOut);
        return inAndOuts;
    }

//        查询所有用户的收支记录(饼图)
    @RequestMapping("/findAllCount")
    @ResponseBody
    public Map<String,String> findAllCount(
            HttpServletRequest request,
            int flag) {
        User user_session = (User) request.getSession().getAttribute("user_session");
        Map<String,String> map = new HashMap<String, String>() ;

        if(flag==0){//0 代表查询柱状图,1代表支出饼状图,2代表收入饼图
//            查询该用户的收入
            String  allIn = inAndOutService.findAllIn(user_session.getName());
//        查询该用户的开支
            String allOut = inAndOutService.findAllOut(user_session.getName());
            map.put("收入",allIn);
            map.put("开支",allOut);

        }else if (flag==1){
            List<InAndOut> allOut = inAndOutService.getAllOut(user_session.getName());
            for (InAndOut inAndOut:allOut) {
                map.put(inAndOut.getK_name(),inAndOut.getCharge());
            }
        }else {
            List<InAndOut> allIn = inAndOutService.getAllIn(user_session.getName());
        }
//
        return map;
    }


    //     增添一条支出记录
    @RequestMapping("/addoutRecord")
    @ResponseBody
    public int addOutRecord(
            @RequestParam("outName") String kindName,
            @RequestParam("outAccount") String outAccount,
            @RequestParam("newoutdate") String newoutdate,
            String outDesc,
            HttpServletRequest request) {

//        获取session
        User user_session = (User) request.getSession().getAttribute("user_session");

        InAndOut inAndOut = new InAndOut();
        inAndOut.setU_name(user_session.getName());
        inAndOut.setK_name(kindName);
        inAndOut.setFlag(0);
        inAndOut.setDesc(outDesc);
        inAndOut.setCharge(outAccount);
        inAndOut.setDate(newoutdate);
        int i = inAndOutService.addRecord(inAndOut);
        int flag = -1;
        if (i <= 0) {
            flag = 0;
        } else {
            flag = 1;
        }
        return flag;
    }
//     增添一条收入记录
    @RequestMapping("/addinRecord")
    @ResponseBody
    public int addInRecord(
            @RequestParam("inName") String kindName,
            @RequestParam("inAccount") String outAccount,
            @RequestParam("newindate") String newoutdate,
            @RequestParam("inDesc") String inDesc,
            HttpServletRequest request) {

//        获取session
        User user_session = (User) request.getSession().getAttribute("user_session");

        InAndOut inAndOut = new InAndOut();
        inAndOut.setU_name(user_session.getName());
        inAndOut.setK_name(kindName);
        inAndOut.setFlag(1);
        inAndOut.setDesc(inDesc);
        inAndOut.setCharge(outAccount);
        inAndOut.setDate(newoutdate);
        int i = inAndOutService.addRecord(inAndOut);
        int flag = -1;
        if (i <= 0) {
            flag = 0;
        } else {
            flag = 1;
        }
        return flag;
    }
//     增添一条预留支出记录
    @RequestMapping("/addpreoutRecord")
    @ResponseBody
    public int addPreOutRecord(
            @RequestParam("preOutName") String kindName,
            @RequestParam("preoutAccount") String preoutAccount,
            @RequestParam("preoutdate") String preoutdate,
            @RequestParam("preoutDesc") String preoutDesc,
            HttpServletRequest request) {

//        获取session
        User user_session = (User) request.getSession().getAttribute("user_session");

        InAndOut inAndOut = new InAndOut();
        inAndOut.setU_name(user_session.getName());
        inAndOut.setK_name(kindName);
        inAndOut.setFlag(3);
        inAndOut.setDesc(preoutDesc);
        inAndOut.setCharge(preoutAccount);
        inAndOut.setDate(preoutdate);
        int i = inAndOutService.addRecord(inAndOut);
        int flag = -1;
        if (i <= 0) {
            flag = 0;
        } else {
            flag = 1;
        }
        return flag;
    }

//    //    修改一条记录的页面
//    @RequestMapping("/updRecordPage")
//    public String updRecordPage() {
//        return "account/updrecordpage";
//    }
//
//    //    修改一条记录
//    @RequestMapping("/updRecord")
//    public String updRecord(
//            @RequestParam("id") int id,
//            @RequestParam("kindName") String kindName,
//            @RequestParam("flag") int flag,
//            @RequestParam("charge") BigDecimal charge,
//            @RequestParam("date") String date,
//            String desc,
//            HttpServletRequest request) {
//
//        if (StringUtils.isBlank("kindName")) {
//            return "消费类别不能为空";
//        }
////        获取session
//        User user_session = (User) request.getSession().getAttribute("user_session");
//
//        InAndOut inAndOut = new InAndOut();
//        inAndOut.setId(id);
//        inAndOut.setU_name(user_session.getName());
//        inAndOut.setK_name(kindName);
//        inAndOut.setFlag(flag);
//        inAndOut.setDesc(desc);
//        inAndOut.setCharge(charge);
//        inAndOut.setDate(date);
//
//        int i = inAndOutService.updRecord(inAndOut);
//        if (i <= 0) {
//            return "修改记录失败！";
//        } else {
//            return "account/allrecordspage";
//        }
//    }
//
//    //    删除一条记录
//    @RequestMapping("/delRecord")
//    public String delRecord(int id,
//                            HttpServletRequest request) {
//        int i = inAndOutService.delRecord(id);
//        if (i <= 0) {
//            return "删除记录失败！";
//        } else {
//            return "account/allrecordspage";
//        }
//    }
}
