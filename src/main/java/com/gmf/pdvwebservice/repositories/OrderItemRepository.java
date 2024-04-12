package com.gmf.pdvwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmf.pdvwebservice.entities.OrderItem;
import com.gmf.pdvwebservice.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
