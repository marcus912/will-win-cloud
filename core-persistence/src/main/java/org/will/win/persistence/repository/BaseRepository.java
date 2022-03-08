package org.will.win.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.will.win.persistence.entity.BaseEntity;

import java.io.Serializable;

public interface BaseRepository<T extends BaseEntity, Integer extends Serializable>
  extends JpaRepository<T, Integer>,
  JpaSpecificationExecutor<T>,
  CrudRepository<T, Integer> {
}
