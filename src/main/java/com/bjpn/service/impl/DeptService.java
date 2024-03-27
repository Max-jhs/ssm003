package com.bjpn.service.impl;

import com.bjpn.bean.Dept;
import com.bjpn.mapper.DeptMapper;
import com.bjpn.service.DeptMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/20:30
 * @Description:
 */
@Service
public class DeptService implements DeptMapperService {
    @Autowired
    private DeptMapper deptMapper;
    //查看所有部门信息
    @Override
    public ArrayList<Dept> selDepts() {
        ArrayList<Dept> depts = deptMapper.selDepts();
        return depts;
    }

    //添加部门
    @Override
    public int addDept(Dept dept) {
        int i = deptMapper.addDept(dept);
        return i;
    }
}
