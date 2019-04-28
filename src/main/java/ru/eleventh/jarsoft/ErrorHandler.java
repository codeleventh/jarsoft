package ru.eleventh.jarsoft;

import org.hibernate.service.spi.ServiceException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(),
                                       null,
                                       HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ServiceException.class, DataAccessException.class,
        NestedRuntimeException.class}) // TODO: ?
    protected ResponseEntity<Object> handleInternalError(RuntimeException e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(),
                                       null,
                                       HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}