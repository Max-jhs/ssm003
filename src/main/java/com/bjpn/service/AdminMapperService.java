package com.bjpn.service;

import com.bjpn.bean.Admin;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/05/11:20
 * @Description:
 */
public interface AdminMapperService {
    public Admin login(String code,String upwd);

    //注册  返回账号
    public String regAdmin(Admin admin);

    //查看账号是否存在
    public String checkCodeUnique(String code);

    //修改密码
    public boolean modifyPwd(String code,String newPwd);

    //完善个人信息
    public int upDataPerson(Admin admin);
}
