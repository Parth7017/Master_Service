package org.nexgen.master.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.nexgen.commons.util.GenericResponseGeneratorUtil;
import org.nexgen.master.service.GeoCountriesService;
import org.nexgen.commons.exceptions.GenericException;
import org.nexgen.commons.model.response.GenericResponse;
import org.nexgen.master.constants.GeoCountrySuccessCodes;
import org.nexgen.master.constants.MasterRestApiEndPoints;
import org.nexgen.master.module.GeoCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/countries")
public class GeoCountriesController {
    @Autowired
    private GeoCountriesService geoCountriesService;

    @Autowired
    private GenericResponseGeneratorUtil genericResponseGeneratorUtil;

    @GetMapping(value= MasterRestApiEndPoints.ACTIVE_LIST)
    @Operation(summary = "Get All Active Countries", description = "API to retrieve a list of all active countries.")
    public GenericResponse getAllCountries(@RequestHeader(value = "locale", defaultValue = "en") String locale)
            throws GenericException {
        try {
            log.info("Inside getAllCountries method");
            List<GeoCountryResponse> countries = geoCountriesService.getAllCountries();

            if (CollectionUtils.isEmpty(countries)) {
                log.warn("No Active Countries found.");
            }else {
                log.info("Successfully retrieved list of active countries, total count: {}", countries.size());
            }
            return genericResponseGeneratorUtil.prepareResponse(
                    countries, GeoCountrySuccessCodes.COUNTRIES_RETRIEVED, locale);

        }catch (Exception e) {
            log.error("Username not found: {}", e.getMessage());
            throw new GenericException(e);
        }
    }
}
