package org.will.win.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.will.win.admin.input.PurchaseItemInput;
import org.will.win.admin.model.PurchaseItem;
import org.will.win.admin.service.PurchaseService;

import java.util.List;

@RestController()
@RequestMapping(path = "/purchase", produces = "application/json")
public class PurchaseController {

  private PurchaseService purchaseService;

  @Autowired
  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @PostMapping("/item")
  public PurchaseItem postPurchaseItem(@RequestBody PurchaseItemInput input) {
    return purchaseService.addPurchaseItem(input);
  }

  @GetMapping("/item")
  public List<PurchaseItem> getPurchaseItems(@PageableDefault(size = 500, sort = "id") Pageable pageable) {
    return purchaseService.searchPurchaseItems(pageable);
  }

  @PutMapping("/item/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public PurchaseItem putPurchaseItem(@RequestBody PurchaseItemInput input, @PathVariable int id) {
    return purchaseService.editPurchaseItem(input, id);
  }

}
