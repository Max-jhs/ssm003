package com.bjpn.bean;

import org.springframework.stereotype.Component;

import javax.lang.model.element.NestingKind;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/05/16:26
 * @Description:
 */
@Component
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminCode;
    private String adminPwd;
    private String adminImg;
    private String adminEmail;
    private String adminPhone;
    private String adminDesc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) &&
                Objects.equals(adminName, admin.adminName) &&
                Objects.equals(adminCode, admin.adminCode) &&
                Objects.equals(adminPwd, admin.adminPwd) &&
                Objects.equals(adminImg, admin.adminImg) &&
                Objects.equals(adminEmail, admin.adminEmail) &&
                Objects.equals(adminPhone, admin.adminPhone) &&
                Objects.equals(adminDesc, admin.adminDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, adminCode, adminPwd, adminImg, adminEmail, adminPhone, adminDesc);
    }

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminCode, String adminPwd, String adminImg, String adminEmail, String adminPhone, String adminDesc) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminCode = adminCode;
        this.adminPwd = adminPwd;
        this.adminImg = adminImg;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
        this.adminDesc = adminDesc;
    }

    /**
     * 获取
     * @return adminId
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置
     * @param adminId
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取
     * @return adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取
     * @return adminCode
     */
    public String getAdminCode() {
        return adminCode;
    }

    /**
     * 设置
     * @param adminCode
     */
    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    /**
     * 获取
     * @return adminPwd
     */
    public String getAdminPwd() {
        return adminPwd;
    }

    /**
     * 设置
     * @param adminPwd
     */
    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    /**
     * 获取
     * @return adminImg
     */
    public String getAdminImg() {
        return adminImg;
    }

    /**
     * 设置
     * @param adminImg
     */
    public void setAdminImg(String adminImg) {
        this.adminImg = adminImg;
    }

    /**
     * 获取
     * @return adminEmail
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     * 设置
     * @param adminEmail
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     * 获取
     * @return adminPhone
     */
    public String getAdminPhone() {
        return adminPhone;
    }

    /**
     * 设置
     * @param adminPhone
     */
    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    /**
     * 获取
     * @return adminDesc
     */
    public String getAdminDesc() {
        return adminDesc;
    }

    /**
     * 设置
     * @param adminDesc
     */
    public void setAdminDesc(String adminDesc) {
        this.adminDesc = adminDesc;
    }

    public String toString() {
        return "Admin{adminId = " + adminId + ", adminName = " + adminName + ", adminCode = " + adminCode + ", adminPwd = " + adminPwd + ", adminImg = " + adminImg + ", adminEmail = " + adminEmail + ", adminPhone = " + adminPhone + ", adminDesc = " + adminDesc + "}";
    }
}
