package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.commons.exceptions.GenericException;
import org.nexgen.commons.model.response.GenericResponse;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.nexgen.master.constants.UserSuccessCodes;
import org.nexgen.master.module.UserResponse;
import org.nexgen.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Users", description = "API to retrieve a list of all users.")
    public GenericResponse getAllActiveUsers(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {

        try {
            log.info("Inside getAllUsers method");
            List<UserResponse> activeUsers = userService.getAllActiveUsers();

            if (CollectionUtils.isEmpty(activeUsers)) {
                log.warn("No active users found.");
            }else {
                log.info("Successfully retrieved list of users, total count: {}", activeUsers.size());
            }

            return genericResponseGeneratorUtil.prepareResponse(activeUsers, UserSuccessCodes.USER_RETRIEVED, locale);
        } catch (Exception e) {
            log.error("Username not found while retrieving active users", e);

            throw new GenericException(e);
        }
    }
}
