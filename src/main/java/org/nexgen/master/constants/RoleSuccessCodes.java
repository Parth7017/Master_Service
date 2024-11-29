package org.nexgen.master.constants;

import org.nexgen.commons.constants.BaseSuccessCodes;
import org.springframework.http.HttpStatus;

public enum RoleSuccessCodes implements BaseSuccessCodes {

    ROLES_RETRIEVED(HttpStatus.OK, "ROLES_RETRIEVED"),
    ROLE_CREATED(HttpStatus.CREATED, "ROLE_CREATED"),
    ROLE_UPDATED(HttpStatus.OK, "ROLE_UPDATED"),
    ROLE_DELETED(HttpStatus.NO_CONTENT, "ROLE_DELETED");

    private final HttpStatus status;
    private final String messageCode;

    RoleSuccessCodes(HttpStatus status, String messageCode) {
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
