package org.will.win.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.will.win.admin.input.UnitInput;
import org.will.win.admin.model.UnitModel;
import org.will.win.persistence.entity.UnitEntity;
import org.will.win.persistence.repository.UnitRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UnitService {

  private final UnitRepository unitRepository;

  @Autowired
  public UnitService(UnitRepository unitRepository) {
    this.unitRepository = unitRepository;
  }

  public UnitModel addUnit(UnitInput input) {
    UnitEntity entity = new UnitEntity();
    entity.setName(input.getName());
    if (Objects.nonNull(input.getStatus())) {
      entity.setStatus(input.getStatus());
    }
    entity.setComment(input.getComment());

    return UnitModel.of(unitRepository.save(entity));
  }

  public UnitModel editUnit(UnitInput input, int id) {
    UnitEntity entity = unitRepository.findById(id).get();
    if (Objects.nonNull(entity)) {
      entity.setName(input.getName());
      if (Objects.nonNull(input.getStatus())) {
        entity.setStatus(input.getStatus());
      }
      entity.setComment(input.getComment());

      return UnitModel.of(unitRepository.save(entity));
    }
    return null;
  }

  public List<UnitModel> getUnits() {
    return unitRepository.findAll().stream()
      .map(e -> UnitModel.of(e)).collect(Collectors.toList());
  }

  public void deleteUnit(int id) {
    UnitEntity entity = unitRepository.findById(id).get();
    if (Objects.nonNull(entity)) {
      unitRepository.delete(entity);
    }
  }
}
