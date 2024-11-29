package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum UserSuccessCodes implements BaseSuccessCodes {

    USER_CREATED(HttpStatus.CREATED, "USER_CREATED"),
    USER_UPDATED(HttpStatus.OK, "USER_UPDATED"),
    USER_DELETED(HttpStatus.NO_CONTENT, "USER_DELETED"),
    USER_RETRIEVED(HttpStatus.OK, "USER_RETRIEVED");

    private final HttpStatus status;
    private final String messageCode;

    UserSuccessCodes(HttpStatus status, String messageCode) {
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
