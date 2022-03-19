package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ColorNotFoundException extends RuntimeException {
  public ColorNotFoundException(int id) {
    super(String.format("Color %s Not Found", id));
  }
}
