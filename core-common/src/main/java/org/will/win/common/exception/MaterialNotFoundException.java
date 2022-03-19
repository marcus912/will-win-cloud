package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MaterialNotFoundException extends RuntimeException {
  public MaterialNotFoundException(int id) {
    super(String.format("Material %s Not Found", id));
  }
}
