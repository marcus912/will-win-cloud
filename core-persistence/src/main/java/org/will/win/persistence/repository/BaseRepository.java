package org.will.win.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<T> extends JpaRepository<T, Integer>,
  JpaSpecificationExecutor<T>,
  CrudRepository<T, Integer> {
}
