package com.bjpn.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/08/21:36
 * @Description:
 */
@Component
public class Emp {
    private Integer empId;
    private String empName;
    private Double empSal;
    private String empHireDate;
    private String empImg;
    private Integer empDeptId;
    private Dept dept;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(empId, emp.empId) &&
                Objects.equals(empName, emp.empName) &&
                Objects.equals(empSal, emp.empSal) &&
                Objects.equals(empHireDate, emp.empHireDate) &&
                Objects.equals(empImg, emp.empImg) &&
                Objects.equals(empDeptId, emp.empDeptId) &&
                Objects.equals(dept, emp.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empSal, empHireDate, empImg, empDeptId, dept);
    }

    public Emp() {
    }

    public Emp(Integer empId, String empName, Double empSal, String empHireDate, String empImg, Integer empDeptId, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
        this.empHireDate = empHireDate;
        this.empImg = empImg;
        this.empDeptId = empDeptId;
        this.dept = dept;
    }

    /**
     * 获取
     * @return empId
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取
     * @return empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取
     * @return empSal
     */
    public Double getEmpSal() {
        return empSal;
    }

    /**
     * 设置
     * @param empSal
     */
    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    /**
     * 获取
     * @return empHireDate
     */
    public String getEmpHireDate() {
        return empHireDate;
    }

    /**
     * 设置
     * @param empHireDate
     */
    public void setEmpHireDate(String empHireDate) {
        this.empHireDate = empHireDate;
    }

    /**
     * 获取
     * @return empImg
     */
    public String getEmpImg() {
        return empImg;
    }

    /**
     * 设置
     * @param empImg
     */
    public void setEmpImg(String empImg) {
        this.empImg = empImg;
    }

    /**
     * 获取
     * @return empDeptId
     */
    public Integer getEmpDeptId() {
        return empDeptId;
    }

    /**
     * 设置
     * @param empDeptId
     */
    public void setEmpDeptId(Integer empDeptId) {
        this.empDeptId = empDeptId;
    }

    /**
     * 获取
     * @return dept
     */
    public Dept getDept() {
        return dept;
    }

    /**
     * 设置
     * @param dept
     */
    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String toString() {
        return "Emp{empId = " + empId + ", empName = " + empName + ", empSal = " + empSal + ", empHireDate = " + empHireDate + ", empImg = " + empImg + ", empDeptId = " + empDeptId + ", dept = " + dept + "}";
    }
}
