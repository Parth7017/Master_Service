package org.nexgen.master.service;

import org.nexgen.master.module.GeoCountryResponse;
import org.nexgen.master.repository.GeoCountriesRepository;
import org.nexgen.schema.entity.GeoCountries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeoCountriesServiceImpl implements GeoCountriesService{
    @Autowired
    private GeoCountriesRepository geoCountriesRepository;

    public List<GeoCountryResponse> getAllCountries() {

        List<GeoCountries> geoCountriesList = geoCountriesRepository.findAllByIsActiveTrue();
        return geoCountriesList.stream()
                .map(country -> new GeoCountryResponse(country.getCountryName(), country.getCountryShortCode()))
                .collect(Collectors.toList());
    }
}
