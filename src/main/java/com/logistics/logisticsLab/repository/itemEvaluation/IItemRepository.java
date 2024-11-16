package com.logistics.logisticsLab.repository.itemEvaluation;

import com.logistics.logisticsLab.model.itemEvaluation.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item,String> {
}
