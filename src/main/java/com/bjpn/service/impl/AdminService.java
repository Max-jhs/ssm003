package com.bjpn.service.impl;
import com.bjpn.bean.Admin;
import com.bjpn.mapper.AdminMapper;
import com.bjpn.service.AdminMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/04/21:13
 * @Description:
 */
@Service
public class AdminService implements AdminMapperService {
    @Autowired
    private AdminMapper adminMapper;

    //登录
    @Override
    public Admin login(String adminCode, String adminPwd) {
        Admin admin = adminMapper.loginAdmin(adminCode, adminPwd);
        return admin;
    }

    //注册管理员
    @Override
    @Transactional
    public String regAdmin(Admin admin) {
//        生成卡号
        while (true) {
            String code = "888" + (new Random().nextInt(900) + 100);
            String s = checkCodeUnique(code);
            if (s == null) {
                //说明账号不存在可以使用
                admin.setAdminCode(code);
                adminMapper.regAdmin(admin);
                //注册成功返回卡号
                return code;
            }
        }
    }



    //产看卡号是否存在
    @Override
    public String checkCodeUnique(String code) {
        String s = adminMapper.checkCodeUnique(code);
        //如果账号不存在返回null
        return s;
    }
    //修改密码
    @Override
    public boolean modifyPwd(String code, String newPwd) {
        boolean b = adminMapper.modifyPwd(code, newPwd);
        return b;
    }
    //完善个人信息
    @Override
    @Transactional
    public int upDataPerson(Admin admin) {
        int i = adminMapper.upDatePerson(admin);
        return i;
    }
//    public void setAdminMapper(AdminMapper adminMapper){
//        this.adminMapper=adminMapper;
//    }
}
