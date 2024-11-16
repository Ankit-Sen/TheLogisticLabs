package com.logistics.logisticsLab.repository.itemEvaluation;

import com.logistics.logisticsLab.controller.itemEvaluation.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<Order,String> {
}
