package org.will.win.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.will.win.persistence.entity.PurchaseItemEntity;

import javax.persistence.QueryHint;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.*;

public interface PurchaseItemRepository extends BaseRepository<PurchaseItemEntity, Integer> {

  @Query("SELECT i FROM PurchaseItemEntity i")
  @QueryHints(value = {
    @QueryHint(name = HINT_FETCH_SIZE, value = "" + Integer.MIN_VALUE),
    @QueryHint(name = HINT_CACHEABLE, value = "false"),
    @QueryHint(name = HINT_READONLY, value = "true"),
    @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")
  })
  Stream<PurchaseItemEntity> searchPurchaseItem();
}
