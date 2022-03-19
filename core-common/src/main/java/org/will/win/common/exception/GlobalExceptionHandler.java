package org.will.win.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.will.win.common.model.ExceptionResponse;

import java.lang.annotation.Annotation;
import java.util.Date;

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
}
