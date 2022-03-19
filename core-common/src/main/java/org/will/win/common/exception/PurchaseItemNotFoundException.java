package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PurchaseItemNotFoundException extends RuntimeException {

  public PurchaseItemNotFoundException(int id) {
    super(String.format("Purchase Item %s Not Found", id));
  }

}
