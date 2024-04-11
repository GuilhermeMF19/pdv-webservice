package com.gmf.pdvwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmf.pdvwebservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
