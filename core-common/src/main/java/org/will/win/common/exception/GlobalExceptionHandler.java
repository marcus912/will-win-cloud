package org.will.win.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.will.win.common.model.ExceptionResponse;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ExceptionResponse> handleExceptions(Throwable e, WebRequest webRequest) {
    ExceptionResponse response = new ExceptionResponse();
    // Find http status from annotation
    Class<?> clazz = e.getClass();
    for (Annotation annotation : clazz.getDeclaredAnnotations()) {
      if (annotation.annotationType().getName().equals("org.springframework.web.bind.annotation.ResponseStatus")) {
        ResponseStatus te = (ResponseStatus) annotation;
        response.setStatus(te.value());
        response.setCode(te.value().value());
        response.setError(te.value().toString());
        break;
      }
    }
    response.setTimestamp(new Date());
    response.setMessage(e.getMessage());
    try {
      response.setPath(((ServletWebRequest) webRequest).getRequest().getRequestURI());
    } catch (Exception ex) {
      logger.error("Cast WebRequest Failed", ex);
    }
    return new ResponseEntity<>(response, response.getStatus());
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
    ExceptionResponse response = new ExceptionResponse();
    response.setStatus(status);
    response.setCode(status.value());
    response.setError(status.toString());
    Map<String, String> errors = new HashMap<>();
    e.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      errors.put(fieldName, message);
    });
    String message = errors.keySet()
      .stream()
      .map(k -> errors.get(k))
      .reduce("", (a, b) -> a.length() > 0 ? a.concat(" ").concat(b) : a.concat(b));
    response.setMessage(message);
    try {
      response.setPath(((ServletWebRequest) webRequest).getRequest().getRequestURI());
    } catch (Exception ex) {
      logger.error("Cast WebRequest Failed", ex);
    }
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
