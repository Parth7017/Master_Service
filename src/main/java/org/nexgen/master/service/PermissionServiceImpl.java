package org.nexgen.master.service;

import org.nexgen.master.module.PermissionResponse;
import org.nexgen.master.repository.PermissionRepository;
import org.nexgen.schema.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionResponse> getActivePermissions() {

        List<Permission> activePermissions = permissionRepository.findAllByIsActiveTrue();

        return activePermissions.stream()
                .map(permission -> new PermissionResponse(
                        permission.getPermissionCode(),
                        permission.getPermission()))
                .collect(Collectors.toList());
    }

}
