package org.nexgen.master.module;

public class RoleResponse {
    private String roleCode;
    private String role;


    public RoleResponse(String roleCode, String role) {
        this.roleCode = roleCode;
        this.role = role;
    }


    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
