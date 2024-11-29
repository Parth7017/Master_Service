package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum GeoCountrySuccessCodes implements BaseSuccessCodes {

    COUNTRIES_RETRIEVED(HttpStatus.OK, "COUNTRIES_RETRIEVED"),
    COUNTRY_CREATED(HttpStatus.CREATED, "COUNTRY_CREATED"),
    COUNTRY_UPDATED(HttpStatus.OK, "COUNTRY_UPDATED"),
    COUNTRY_DELETED(HttpStatus.NO_CONTENT, "COUNTRY_DELETED");

    private final HttpStatus status;
    private final String messageCode;

    GeoCountrySuccessCodes(HttpStatus status, String messageCode) {
        this.status = status;
        this.messageCode = messageCode;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessageCode() {
        return messageCode;
    }
}
