package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.constants.DayOfWeekDetailSuccessCodes;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.nexgen.master.module.DayOfWeekDetailResponse;
import org.nexgen.master.service.DayOfWeekDetailService;
import org.nexgen.commons.exceptions.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/day-of-week-details")
public class DayOfWeekDetailController {
    @Autowired
    private DayOfWeekDetailService dayOfWeekDetailService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Active Day of Week Details", description = "API to retrieve a list of all active day of week details.")
    public Object getActiveDayOfWeekDetails(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {

        try {
            log.info("Inside getAllCountries method");
            List<DayOfWeekDetailResponse> activeDayOfWeekDetails = dayOfWeekDetailService.getActiveDayOfWeekDetails();

            if (CollectionUtils.isEmpty(activeDayOfWeekDetails)) {
                log.warn("No Days of Weeks found.");
            }else {
                log.info("Successfully retrieved list of day of week, total count: {}", activeDayOfWeekDetails.size());
            }
            return genericResponseGeneratorUtil.prepareResponse(activeDayOfWeekDetails, DayOfWeekDetailSuccessCodes.DAY_OF_WEEK_DETAILS_RETRIEVED, locale);
        }catch (Exception e) {
            log.error("Username not found exception occurred while retrieving day of week details: {}", e.getMessage(), e);
            e.printStackTrace();

            throw new GenericException(e);
        }
    }
}
