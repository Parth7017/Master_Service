package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.master.module.HolidayCategoryResponse;
import org.nexgen.master.service.HolidayCategoryService;
import org.nexgen.commons.exceptions.GenericException;
import org.nexgen.commons.model.response.GenericResponse;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.constants.HolidayCategorySuccessCodes;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/holiday-categories")
public class HolidayCategoryController {
    @Autowired
    private HolidayCategoryService holidayCategoryService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Active Holiday Categories", description = "API to retrieve a list of all active holiday categories.")
    public GenericResponse getActiveHolidayCategories(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {
       try {
           log.info("Inside getActiveHolidayCategories method");

           List<HolidayCategoryResponse> activeHolidayCategories = holidayCategoryService.getActiveHolidayCategories();

           if (CollectionUtils.isEmpty(activeHolidayCategories)) {
               log.warn("No active Holiday found.");
           }else {
               log.info("Successfully retrieved list of active holidays, total count: {}", activeHolidayCategories.size());
           }

           return genericResponseGeneratorUtil.prepareResponse(activeHolidayCategories, HolidayCategorySuccessCodes.HOLIDAY_CATEGORIES_RETRIEVED, locale);
       }catch (Exception e) {
           log.error("Username not found while retrieving active holiday categories", e);

           throw new GenericException(e);
       }
    }
}
