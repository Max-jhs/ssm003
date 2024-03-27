package com.bjpn.controller;

import com.bjpn.bean.Admin;
import com.bjpn.service.AdminMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/05/17:23
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminMapperService adminMapperService;
    //去主页
    @RequestMapping("/toIndex.action")
    public String toIndex() {
        return "page/admin/index";
    }

    //    退出登录  杀死session  推到登陆页面
    @RequestMapping("/exitLogin.action")
    public String exitLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "/page/login";
    }

    //点击修改密码去到pass页面
    @RequestMapping("/toModifyPwd.action")
    public String toModifyPwd() {
        return "/page/admin/pass";
    }

    //修改密码
    @RequestMapping("/modifyPwd.action")
    public String modifyPwd(HttpSession session, String newpass) {
        Admin admin = (Admin) session.getAttribute("Admin");
        System.out.println(admin);
        boolean b = adminMapperService.modifyPwd(admin.getAdminCode(), newpass);
        System.out.println("b = " + b);
        //修改成功要求 right 回到星空图业面
        return "forward:/login/backIndex.action";
//        return "/page/admin/backIndex";

    }


    //点击个人信息去到person页面
    @RequestMapping("/toPerson.action")
    public String toPerson() {
        return "/page/admin/personal";
    }

    //完善个人信息
    @RequestMapping("/upDatePerson.action")
    public String upDatePerson(MultipartFile file2, String email, String ephone, String enote, HttpServletRequest request) throws IOException {
        Admin admin = (Admin) request.getSession().getAttribute("Admin");
        admin.setAdminDesc(enote);
        admin.setAdminEmail(email);
        admin.setAdminPhone(ephone);
        //截取真实文件的后缀
        if (!file2.isEmpty()) {
            String houzhui = file2.getOriginalFilename().substring(file2.getOriginalFilename().lastIndexOf("."));
            System.out.println("houzhui = " + houzhui);
            //文件上传保存的名字命名为用户账号 adminImg  =  888888.jpg
            String photoName = admin.getAdminCode() + houzhui;
            admin.setAdminImg(photoName);
            //头像保存路径  /images/888888.jpg
            String path = request.getServletContext().getRealPath("/") + "/images/" + photoName;
            System.out.println("path = " + path);
            File file = new File(path);
            file2.transferTo(file);
        }
        //更新操作
        int i = adminMapperService.upDataPerson(admin);
        System.out.println(i);
        //修改完毕右侧退到星空页面
//        return "redirect:/login/backIndex.action";
        return "/page/admin/backIndex";
    }

}
