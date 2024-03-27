package com.bjpn.controller;

import com.bjpn.bean.Emp;
import com.bjpn.service.EmpMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/09/19:21
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestController {
    public static void main(String[] args) {
        String i = "1" + null;
        System.out.println("i = " + i);
    }
}
