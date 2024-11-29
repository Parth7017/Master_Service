package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.commons.exceptions.GenericException;
import org.nexgen.commons.model.response.GenericResponse;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.nexgen.master.constants.RoleSuccessCodes;
import org.nexgen.master.module.RoleResponse;
import org.nexgen.master.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Active Roles", description = "API to retrieve a list of all active roles.")
    public GenericResponse getActiveRoles(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {
        try {
            log.info("Inside getActiveRoles method");

            List<RoleResponse> activeRoles = roleService.getActiveRoles();

            if (CollectionUtils.isEmpty(activeRoles)) {
                log.warn("No active Roles found.");
            }else {
                log.info("Successfully retrieved list of roles, total count: {}", activeRoles.size());
            }
            return genericResponseGeneratorUtil.prepareResponse(
                    activeRoles, RoleSuccessCodes.ROLES_RETRIEVED, locale);

        }catch (Exception e) {

            log.error("Username not found while retrieving active roles", e);

            throw new GenericException(e);
        }
    }
}
