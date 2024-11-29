package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum DayOfWeekDetailSuccessCodes implements BaseSuccessCodes {

    DAY_OF_WEEK_DETAILS_RETRIEVED(HttpStatus.OK, "DAY_OF_WEEK_DETAILS_RETRIEVED"),
    DAY_OF_WEEK_DETAIL_CREATED(HttpStatus.CREATED, "DAY_OF_WEEK_DETAIL_CREATED"),
    DAY_OF_WEEK_DETAIL_UPDATED(HttpStatus.OK, "DAY_OF_WEEK_DETAIL_UPDATED"),
    DAY_OF_WEEK_DETAIL_DELETED(HttpStatus.NO_CONTENT, "DAY_OF_WEEK_DETAIL_DELETED");

    private final HttpStatus status;
    private final String messageCode;

    // Constructor for each enum constant
    DayOfWeekDetailSuccessCodes(HttpStatus status, String messageCode) {
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
