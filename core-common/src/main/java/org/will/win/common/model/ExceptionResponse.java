package org.will.win.common.model;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionResponse {
  private Date timestamp;
  private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
  private String error = HttpStatus.INTERNAL_SERVER_ERROR.toString();
  private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
  private String message;
  private String path;

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
