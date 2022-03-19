package org.will.win.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemPriceNotFoundException extends RuntimeException {
  public ItemPriceNotFoundException(int id) {
    super(String.format("Item Price %s Not Found", id));
  }
}
