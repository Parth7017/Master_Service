package org.nexgen.master.service;

import org.nexgen.master.module.RoleResponse;
import org.nexgen.master.repository.RoleRepository;
import org.nexgen.schema.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleResponse> getActiveRoles() {

        List<Role> activeRoles = roleRepository.findAllByIsActiveTrue();

        return activeRoles.stream()
                .map(role -> new RoleResponse(role.getRoleCode(), role.getRole()))
                .collect(Collectors.toList());
    }
}
