package org.will.win.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.will.win.admin.input.UnitInput;
import org.will.win.admin.model.UnitModel;
import org.will.win.admin.service.UnitService;

import java.util.List;

@RestController
@RequestMapping(path = "/units", produces = "application/json")
public class UnitController {

  final private UnitService unitService;

  @Autowired
  public UnitController(UnitService unitService) {
    this.unitService = unitService;
  }

  @PostMapping()
  public UnitModel postUnit(@RequestBody UnitInput input) {
    return unitService.addUnit(input);
  }

  @PutMapping("/{id}")
  public UnitModel putUnit(@RequestBody UnitInput input, @PathVariable int id) {
    return unitService.editUnit(input, id);
  }

  @GetMapping()
  public List<UnitModel> putUnit() {
    return unitService.getUnits();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void putUnit(@PathVariable int id) {
    unitService.deleteUnit(id);
  }
}
