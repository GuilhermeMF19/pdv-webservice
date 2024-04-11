package com.gmf.pdvwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmf.pdvwebservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
