package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:32 2019/3/18
 */
public class Role {
    private String roleId;
    private String roleName;
    private String remarks;
    private Integer delFlag;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlage) {
        this.delFlag = delFlage;
    }
}
