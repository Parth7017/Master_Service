package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum HolidayCategorySuccessCodes implements BaseSuccessCodes {

    HOLIDAY_CATEGORIES_RETRIEVED(HttpStatus.OK, "HOLIDAY_CATEGORIES_RETRIEVED"),
    HOLIDAY_CATEGORY_CREATED(HttpStatus.CREATED, "HOLIDAY_CATEGORY_CREATED"),
    HOLIDAY_CATEGORY_UPDATED(HttpStatus.OK, "HOLIDAY_CATEGORY_UPDATED"),
    HOLIDAY_CATEGORY_DELETED(HttpStatus.NO_CONTENT, "HOLIDAY_CATEGORY_DELETED");

    private final HttpStatus status;
    private final String messageCode;

    HolidayCategorySuccessCodes(HttpStatus status, String messageCode) {
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
