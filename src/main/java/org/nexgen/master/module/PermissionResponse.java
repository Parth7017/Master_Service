package org.nexgen.master.module;

public class PermissionResponse {
    private String permissionCode;
    private String permission;

    public PermissionResponse(String permissionCode, String permission) {
        this.permissionCode = permissionCode;
        this.permission = permission;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
