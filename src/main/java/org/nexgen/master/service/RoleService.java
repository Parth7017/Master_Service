package org.nexgen.master.service;

import org.nexgen.master.module.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getActiveRoles();

}
