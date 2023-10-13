package com.nonso.walletrestapi.exception.handler;

import com.nonso.walletrestapi.exception.ErrorCode;
import com.nonso.walletrestapi.exception.WalletRestException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.nonso.walletrestapi.exception.ErrorCode.CONSTRAINT_VIOLATION;

@RestControllerAdvice
public class WalletRestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
     *
     * @param ex the MethodArgumentNotValidException that is thrown when @Valid validation fails.
     * @param headers HttpHeaders
     * @param status HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Nullable
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        return buildResponseEntity(getValidationErrors(ex.getBindingResult().getFieldErrors()),
                CONSTRAINT_VIOLATION, "Invalid method argument", HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
                                                               @NonNull HttpHeaders headers,
                                                               @NonNull HttpStatusCode status,
                                                               @NonNull WebRequest request) {
        return handleExceptionInternal(ex, getError(ex), headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            @NonNull MissingServletRequestParameterException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        return handleExceptionInternal(ex, getError(ex), headers, status, request);
    }


    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            @NonNull HttpMessageNotReadableException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request) {
        return buildResponseEntity("Malformed JSON request", ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        return buildResponseEntity(getValidationErrors(ex.getConstraintViolations()), CONSTRAINT_VIOLATION,
                "Constraint violation", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WalletRestException.class)
    public ResponseEntity<Object> handleCustomException(WalletRestException e) {
        return buildResponseEntity(e.getMessage(), e.getErrorCode(), ExceptionUtils.getMessage(e), e.getHttpStatus());
    }


    private ResponseEntity<Object> buildResponseEntity(String apiResponse, String message, HttpStatus status) {
        return new ResponseEntity<>(new ApiError(message, getError(apiResponse)), status);
    }

    private ResponseEntity<Object> buildResponseEntity(String apiResponse, ErrorCode ec, String message, HttpStatus status) {
        return  new ResponseEntity<>(new ApiError(message, getError(apiResponse), String.valueOf(ec)), status);
    }
    private ResponseEntity<Object> buildResponseEntity(Object apiResponse, String message, HttpStatus status) {
        return new ResponseEntity<>(new ApiError(message, apiResponse), status);
    }

    private ResponseEntity<Object> buildResponseEntity(Object apiResponse, ErrorCode ec, String message, HttpStatus status) {
        return new ResponseEntity<>(new ApiError(message, apiResponse, String.valueOf(ec)),status);
    }
    private Map<String, String> getValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
        Map<String, String> errors = new HashMap<>();
        constraintViolations.forEach(e ->
                errors.put(((PathImpl) e.getPropertyPath()).getLeafNode().asString(), e.getMessage())
        );
        return errors;
    }
    private Map<String, String> getValidationErrors(List<FieldError> fieldErrors) {
        Map<String, String> errors = new HashMap<>();
        fieldErrors.forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return errors;
    }
    private Map<String, Object> getError(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return response;
    }
    private Map<String, Object> getError(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", message);
        return response;
    }
}
