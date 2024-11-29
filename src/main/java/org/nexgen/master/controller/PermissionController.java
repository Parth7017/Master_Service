package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.master.module.PermissionResponse;
import org.nexgen.commons.exceptions.GenericException;
import org.nexgen.commons.model.response.GenericResponse;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.nexgen.master.constants.PermissionSuccessCodes;
import org.nexgen.master.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Active Permissions", description = "API to retrieve a list of all active permissions.")
    public GenericResponse getActivePermissions(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {
         try {

             log.info("Inside getActivePermissions method");

             List<PermissionResponse> activePermissions = permissionService.getActivePermissions();

             if (CollectionUtils.isEmpty(activePermissions)) {
                 log.warn("No active Permissions found.");
             }else {
                 log.info("Successfully retrieved list of permissions, total count: {}", activePermissions.size());
             }

             return genericResponseGeneratorUtil.prepareResponse(activePermissions, PermissionSuccessCodes.PERMISSIONS_RETRIEVED, locale);
         }catch (Exception e) {

             log.error("Username not found while retrieving active permissions", e);

             throw new GenericException(e);
         }
    }
}
