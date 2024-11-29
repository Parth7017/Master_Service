package org.nexgen.master.service;

import org.nexgen.master.module.PermissionResponse;

import java.util.List;

public interface PermissionService {
    List<PermissionResponse> getActivePermissions();

}
