package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.master.constants.MonthOfYearDetailSuccessCodes;
import org.nexgen.commons.exceptions.GenericException;
import org.nexgen.commons.model.response.GenericResponse;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.nexgen.master.module.MonthOfYearDetailResponse;
import org.nexgen.master.service.MonthOfYearDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/month-of-year")
public class MonthOfYearDetailController {
    @Autowired
    private MonthOfYearDetailService monthOfYearDetailService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Active Month of Year Details", description = "API to retrieve a list of all active month of year details.")
    public GenericResponse getActiveMonths(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {
        try {
            log.info("Inside getActiveMonths method");
            List<MonthOfYearDetailResponse> activeMonths = monthOfYearDetailService.getAllMonthOfYearDetails();

            if (CollectionUtils.isEmpty(activeMonths)) {
                log.warn("No months found.");
            } else{
                log.info("Successfully retrieved list of months, total count: {}", activeMonths.size());
            }
            return genericResponseGeneratorUtil.prepareResponse(activeMonths, MonthOfYearDetailSuccessCodes.MONTHS_RETRIEVED, locale);
        } catch (Exception e) {
            log.error("Username not found while retrieving active month details", e);

            throw new GenericException(e);
        }
    }
}
