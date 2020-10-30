package com.app.mspessoa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArtefatoNaoEncontradoException extends RuntimeException {
    public ArtefatoNaoEncontradoException(final String message) {
        this(message, null);
    }

    public ArtefatoNaoEncontradoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
