package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum MonthOfYearDetailSuccessCodes implements BaseSuccessCodes {

    MONTHS_RETRIEVED(HttpStatus.OK, "MONTHS_RETRIEVED");

    private final HttpStatus status;
    private final String messageCode;

    // Constructor for each enum constant
    MonthOfYearDetailSuccessCodes(HttpStatus status, String messageCode) {
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
