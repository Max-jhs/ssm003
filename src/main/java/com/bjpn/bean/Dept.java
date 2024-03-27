package com.bjpn.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/20:12
 * @Description:
 */
@Component
public class Dept {
    private Integer deptId;
    private String deptName;
    private String deptAddr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(deptId, dept.deptId) &&
                Objects.equals(deptName, dept.deptName) &&
                Objects.equals(deptAddr, dept.deptAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, deptAddr);
    }

    public Dept() {
    }

    public Dept(Integer deptId, String deptName, String deptAddr) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptAddr = deptAddr;
    }

    /**
     * 获取
     * @return deptId
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取
     * @return deptAddr
     */
    public String getDeptAddr() {
        return deptAddr;
    }

    /**
     * 设置
     * @param deptAddr
     */
    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }

    public String toString() {
        return "Dept{deptId = " + deptId + ", deptName = " + deptName + ", deptAddr = " + deptAddr + "}";
    }
}
