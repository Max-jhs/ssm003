package com.bjpn.mapper;

import com.bjpn.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/17:13
 * @Description:
 */
public interface EmpMapper {
    //添加员工
    boolean addEmp(Emp emp);

    //查看所有员工
    ArrayList<Emp> showEmps(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize,@Param("empName") String empName);

    //删除员工
    int delEmp(int empId);

    //修改员工信息
    int upDateEmp(Emp emp);

    //根据empId查看员工信息
    Emp selEmpById(int empId);

    //查看总的员工数据量
    int selEmp(String empName);

    //批量删除
    int delEmps(String[] empIds);
}
