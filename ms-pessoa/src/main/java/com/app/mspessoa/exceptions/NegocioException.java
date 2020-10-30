package com.app.mspessoa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException {
    public NegocioException(final String message) {
        this(message, null);
    }

    public NegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
