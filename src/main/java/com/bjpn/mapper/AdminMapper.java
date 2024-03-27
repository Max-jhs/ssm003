package com.bjpn.mapper;

import com.bjpn.bean.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/04/20:58
 * @Description:
 */
public interface AdminMapper {

    Admin loginAdmin(@Param("Code") String code, @Param("pwd") String password);

    //注册
    int regAdmin(Admin admin);

    //查看账号是否存在
    String checkCodeUnique(String code);

    //修改密码
    boolean modifyPwd(@Param("code") String code, @Param("newPwd") String newPwd);

    //完善个人信息
    int upDatePerson(Admin admin);

}
