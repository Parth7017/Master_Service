package org.nexgen.master.service;

import org.nexgen.master.module.GeoCountryResponse;

import java.util.List;

public interface GeoCountriesService {
    public List<GeoCountryResponse> getAllCountries();

}
