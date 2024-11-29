package org.nexgen.master.module;

public class GeoCountryResponse {
    private String countryName;
    private String countryCode;


    public GeoCountryResponse(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
