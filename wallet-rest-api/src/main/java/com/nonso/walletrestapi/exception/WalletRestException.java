package com.nonso.walletrestapi.exception;

import ch.qos.logback.core.spi.ErrorCodes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class WalletRestException extends RuntimeException{
    protected HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String infoLink;
    private String metadata;

    public WalletRestException(final String message) {
        super(message);
    }

    public WalletRestException(final String message, final HttpStatus httpStatus) {
        this(message);
        this.httpStatus = httpStatus;
    }

    public WalletRestException(final String message, final HttpStatus httpStatus, final ErrorCode errorCode) {
        this(message, httpStatus);
        this.errorCode = errorCode;
    }

    public WalletRestException(final String message, final HttpStatus httpStatus, final String metadata) {
        this(message, httpStatus);
        this.metadata = metadata;
    }

    public WalletRestException(final String message, final HttpStatus httpStatus, final ErrorCode errorCode, final String metadata) {
        this(message, httpStatus, errorCode);
        this.metadata = metadata;
    }
}
