package org.will.win.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PurchaseController {

  @GetMapping("/")
  public String index() {
    return "PurchaseController";
  }
}
