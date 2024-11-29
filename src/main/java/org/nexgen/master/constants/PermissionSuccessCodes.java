package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum PermissionSuccessCodes implements BaseSuccessCodes {

    PERMISSIONS_RETRIEVED(HttpStatus.OK, "PERMISSIONS_RETRIEVED"),
    PERMISSION_CREATED(HttpStatus.CREATED, "PERMISSION_CREATED"),
    PERMISSION_UPDATED(HttpStatus.OK, "PERMISSION_UPDATED"),
    PERMISSION_DELETED(HttpStatus.NO_CONTENT, "PERMISSION_DELETED");

    private final HttpStatus status;
    private final String messageCode;

    PermissionSuccessCodes(HttpStatus status, String messageCode) {
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
