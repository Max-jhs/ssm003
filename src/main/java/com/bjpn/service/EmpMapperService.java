package com.bjpn.service;

import com.bjpn.bean.Emp;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/19:05
 * @Description:
 */
public interface EmpMapperService {
    boolean addEmp(Emp emp);

    //查看所有员工信息
    ArrayList<Emp> showEmps(int startIndex,int pageSize,String empName);

    //删除员工
    int delEmp(int empId);

    //修改员工信息
    int upDateEmp(Emp emp);

    //根据员工Id查询员工信息
    Emp selEmpById(int empId);

    //查看员工总量
    int selEmp(String empName);

    //批量删除
    int delEmps(String[] empIds);
}
