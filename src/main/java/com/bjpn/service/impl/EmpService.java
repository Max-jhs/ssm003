package com.bjpn.service.impl;

import com.bjpn.bean.Emp;
import com.bjpn.mapper.EmpMapper;
import com.bjpn.service.EmpMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/19:05
 * @Description:
 */
@Service
@Transactional
public class EmpService implements EmpMapperService {
    @Autowired
    private EmpMapper empMapper;

    //添加员工
    @Override
    public boolean addEmp(Emp emp) {
        boolean b = empMapper.addEmp(emp);
        return b;
    }

    //查看所有员工
    @Override
    public ArrayList<Emp> showEmps(int startIndex,int pageSize,String empName) {
        ArrayList<Emp> empList = empMapper.showEmps(startIndex,pageSize,empName);
        return empList;
    }
    //删除员工
    @Override
    public int delEmp(int empId) {
        int i = empMapper.delEmp(empId);
        return i;
    }
    //修改员工信息
    @Override
    public int upDateEmp(Emp emp) {
        int i = empMapper.upDateEmp(emp);
        return i;
    }
    //根据员工id查看员工信息
    @Override
    public Emp selEmpById(int empId) {
        Emp emp = empMapper.selEmpById(empId);
        return emp;
    }

    //查看用户总量
    @Override
    public int selEmp(String empName) {
        int i = empMapper.selEmp(empName);
        return i;
    }
    //批量删除
    @Override
    public int delEmps(String[] empIds) {
        int i = empMapper.delEmps(empIds);
        return i;
    }
}
