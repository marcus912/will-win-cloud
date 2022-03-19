package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PurchaseOrderNotFoundException extends RuntimeException {
  public PurchaseOrderNotFoundException(int id) {
    super(String.format("Purchase Order %s Not Found", id));
  }
}
