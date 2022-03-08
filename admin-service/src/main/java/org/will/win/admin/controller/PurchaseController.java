package org.will.win.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.will.win.admin.input.PurchaseItemInput;
import org.will.win.admin.model.PurchaseItem;
import org.will.win.admin.service.PurchaseService;

@RestController()
public class PurchaseController {

  private PurchaseService purchaseService;

  @Autowired
  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @GetMapping("/")
  public String index() {
    return "PurchaseController";
  }

  @PostMapping("/purchase-item")
  public PurchaseItem postPurchaseItem(@RequestBody PurchaseItemInput input) {
    return purchaseService.addPurchaseItem(input);
  }

}
