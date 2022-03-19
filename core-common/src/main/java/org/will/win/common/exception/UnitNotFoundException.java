package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnitNotFoundException extends RuntimeException {
  public UnitNotFoundException(int id) {
    super(String.format("Unit %s Not Found", id));
  }
}
