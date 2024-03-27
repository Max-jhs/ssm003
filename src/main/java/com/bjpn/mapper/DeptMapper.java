package com.bjpn.mapper;

import com.bjpn.bean.Dept;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/20:14
 * @Description:
 */
public interface DeptMapper {
    //查看所有部门  多行多列
    ArrayList<Dept> selDepts();

    //添加部门
    int addDept(Dept dept);

    //根据部门id查部门对象
    Dept selDept(int deptId);
}
