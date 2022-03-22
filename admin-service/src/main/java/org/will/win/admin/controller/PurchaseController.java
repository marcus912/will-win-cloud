package org.will.win.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.will.win.admin.input.PurchaseCustomerInput;
import org.will.win.admin.input.PurchaseItemInput;
import org.will.win.admin.input.PurchaseOrderInput;
import org.will.win.admin.model.PurchaseCustomer;
import org.will.win.admin.model.PurchaseItem;
import org.will.win.admin.model.PurchaseOrder;
import org.will.win.admin.service.PurchaseService;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(path = "/purchase", produces = "application/json")
public class PurchaseController {

  private PurchaseService purchaseService;

  @Autowired
  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @PostMapping("/items")
  public PurchaseItem postPurchaseItem(@Valid @RequestBody PurchaseItemInput input) {
    return purchaseService.addPurchaseItem(input);
  }

  @GetMapping("/items")
  public List<PurchaseItem> searchPurchaseItems(@PageableDefault(size = 500, sort = "id") Pageable pageable) {
    return purchaseService.searchPurchaseItems(pageable);
  }

  @PutMapping("/items/{id}")
  public PurchaseItem putPurchaseItem(@RequestBody PurchaseItemInput input, @PathVariable int id) {
    return purchaseService.editPurchaseItem(input, id);
  }

  @DeleteMapping("/items/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deletePurchaseItem(@PathVariable int id) {
    purchaseService.deletePurchaseItem(id);
  }


  // =========================== Order ===========================

  @PostMapping("/orders")
  public PurchaseOrder postPurchaseOrder(@RequestBody PurchaseOrderInput input) {
      return purchaseService.addPurchaseOrder(input);
  }

  @GetMapping("/orders")
  public List<PurchaseOrder> searchPurchaseOrders(@PageableDefault(size = 500, sort = "id") Pageable pageable) {
    return purchaseService.searchPurchaseOrders(pageable);
  }

  @PutMapping("/orders/{id}")
  public PurchaseOrder putPurchaseOrder(@RequestBody PurchaseOrderInput input, @PathVariable int id) {
    return purchaseService.editPurchaseOrder(input, id);
  }

  @DeleteMapping("/orders/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deletePurchaseOrder(@PathVariable int id) {
    purchaseService.deletePurchaseOrder(id);
  }


  // =========================== Customer ===========================

  @PostMapping("/customers")
  public PurchaseCustomer postPurchaseCustomer(@RequestBody PurchaseCustomerInput input) {
    return purchaseService.addPurchaseCustomer(input);
  }

  @GetMapping("/customers")
  public List<PurchaseCustomer> searchPurchaseCustomers(@PageableDefault(size = 500, sort = "id") Pageable pageable) {
    return purchaseService.searchPurchaseCustomers(pageable);
  }

  @PutMapping("/customers/{id}")
  public PurchaseCustomer putPurchaseCustomer(@RequestBody PurchaseCustomerInput input, @PathVariable int id) {
    return purchaseService.editPurchaseCustomer(input, id);
  }

  @DeleteMapping("/customers/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deletePurchaseCustomer(@PathVariable int id) {
    purchaseService.deletePurchaseCustomer(id);
  }

}
