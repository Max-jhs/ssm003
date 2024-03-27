package com.bjpn.controller;

import com.bjpn.bean.Dept;
import com.bjpn.service.DeptMapperService;
import com.bjpn.util.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/20:14
 * @Description:
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptMapperService deptMapperService;

    //异步查看所有部门
    @RequestMapping("/showDepts.action")
    @ResponseBody
    public   ResultObject showDepts(ResultObject resultObject) {
        ArrayList<Dept> depts = deptMapperService.selDepts();
        if (depts != null) {
            // 部门集合不为空
//            resultObject.setResultMsg(MessageUtil.);
            resultObject.setResultMap("deptList", depts);
        }
        return resultObject;
    }



    //点击部门管理去到部门主页面
    @RequestMapping("/showDept.action")
    public String showDept(HttpServletRequest request) {
        ArrayList<Dept> depts = deptMapperService.selDepts();
        request.setAttribute("depts", depts);
        return "/page/dept/dept";
    }

    //去添加
    @RequestMapping("toAddDept.action")
    public String toAddDept(){
        return "/page/dept/addDept";
    }

    //点击添加部门添加
    @RequestMapping("/addDept.action")
    public String addDept(Dept dept){
        int i = deptMapperService.addDept(dept);
        if (i > 0) {
            //添加成功去到部门页面
            return "forward:/dept/showDept.action";
        }
        return null;
    }
}
