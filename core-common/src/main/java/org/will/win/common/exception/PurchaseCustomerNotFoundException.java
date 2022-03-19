package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PurchaseCustomerNotFoundException extends RuntimeException {
  public PurchaseCustomerNotFoundException(int id) {
    super(String.format("Purchase Customer %s Not Found", id));
  }
}
