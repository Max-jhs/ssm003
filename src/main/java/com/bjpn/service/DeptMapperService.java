package com.bjpn.service;

import com.bjpn.bean.Dept;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/20:29
 * @Description:
 */
public interface DeptMapperService {
    //查看所有部门名称
    ArrayList<Dept> selDepts();

    //添加部门
    int addDept(Dept dept);

}
