package com.logistics.logisticsLab.repository.itemEvaluation;

import com.logistics.logisticsLab.model.itemEvaluation.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderRepository extends CrudRepository<Order,Long> {

    public List<Order>  findAll();
}
