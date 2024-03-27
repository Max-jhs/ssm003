package com.bjpn.controller;

import com.bjpn.bean.Admin;
import com.bjpn.service.AdminMapperService;
import com.bjpn.service.impl.AdminService;
import com.bjpn.util.MessageUtil;
import com.bjpn.util.ResultObject;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/04/20:13
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired()
    private AdminMapperService adminMapperService;

    //登陆页面
    @RequestMapping("/toLogin.action")
    public String login() {
        return "/page/login";
    }
    //同步登录页面处理器
    @RequestMapping("/Login.action")
    public String toLogin(String Code, String Password, String loginFlag, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("hhahhahahahahahha");
        Admin admin = adminMapperService.login(Code, Password);
        if (admin != null) {
            //用户存在 保存用户信息
            session.setAttribute("Admin", admin);
            //记住密码
            Cookie cookieCode = new Cookie("loginCode", Code);
            Cookie cookieUpwd = new Cookie("loginUpwd", Password);
            //前端用loginCode拿 而不是 cookieCode
            if (loginFlag != null) {
                cookieCode.setMaxAge(60 * 60 * 24 * 7);
                cookieUpwd.setMaxAge(60 * 60 * 24 * 7);
            } else {
                cookieCode.setMaxAge(0);
                cookieUpwd.setMaxAge(0);
            }
           //设置cookie路径????????????????????????
            cookieCode.setPath("/");
            cookieUpwd.setPath("/");
            response.addCookie(cookieCode);
            response.addCookie(cookieUpwd);

            return "redirect:/admin/toIndex.action";
        } else {
            request.setAttribute("loginError", "账号或密码有误！");
            return "page/login";
        }
    }
    //异步登录
    @RequestMapping("/ajaxLogin.action")
    @ResponseBody  //这个注解说明这是异步处理函数  把返回值拆成json字符串返回给请求者
    public ResultObject ajaxLogin(String adminCode,String adminPwd,HttpSession session,Boolean loginFlag,HttpServletResponse response,ResultObject resultObject){
        System.out.println("heiheiheihei");
        Admin admin = adminMapperService.login(adminCode, adminPwd);
        if (admin != null) {
            //用户存在 保存用户信息
            session.setAttribute("Admin", admin);
            //记住密码
            Cookie cookieCode = new Cookie("loginCode", adminCode);
            Cookie cookieUpwd = new Cookie("loginUpwd", adminPwd);
            //前端用loginCode拿 而不是 cookieCode
            if (loginFlag) {
                cookieCode.setMaxAge(60 * 60 * 24 * 7);
                cookieUpwd.setMaxAge(60 * 60 * 24 * 7);
            } else {
                cookieCode.setMaxAge(0);
                cookieUpwd.setMaxAge(0);
            }
            //设置cookie路径????????????????????????
            cookieCode.setPath("/");
            cookieUpwd.setPath("/");
            response.addCookie(cookieCode);
            response.addCookie(cookieUpwd);
            //成功回执成功前台alert
            resultObject.setResultCode(MessageUtil.LOGIN_SUCCESSCODE);
            resultObject.setResultMsg(MessageUtil.LOGIN_SUCCESS);
            return resultObject;
        } else {
            resultObject.setResultMsg(MessageUtil.LOGIN_FAILED);
            resultObject.setResultCode(MessageUtil.LOGIN_FAILEDCODE);
            return resultObject;
        }
    }

    //主页背景
    @RequestMapping("/backIndex.action")
    public String backIndex() {
        return "/page/admin/backIndex";
    }

    //注册
    @RequestMapping("/regAdmin.action")
    //异步注册处理器  返回值必须是keyvalue  对象或数组
    @ResponseBody
    public ResultObject regMethod(Admin admin,ResultObject resultObject) {
        //异步请求的数据根据admin属性值直接赋值
        //返回账号
        String code = adminMapperService.regAdmin(admin);
        System.out.println("code = " + code);
        if (code != null) {
            //注册成功并把账号通过resultObject返回到调用处
            resultObject.setResultMsg(MessageUtil.REG_SUCCESS);
            resultObject.setResultCode(MessageUtil.REG_SUCCESSCODE);
            resultObject.setResultMap("adminCode", code);
        }else {
            resultObject.setResultMsg(MessageUtil.REG_FAILED);
            resultObject.setResultCode(MessageUtil.REG_FAILEDCODE);
        }
        return resultObject;
    }
}
