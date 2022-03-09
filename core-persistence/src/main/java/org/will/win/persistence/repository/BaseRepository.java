package org.will.win.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.will.win.persistence.entity.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
  extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>, CrudRepository<T, ID> {
}
