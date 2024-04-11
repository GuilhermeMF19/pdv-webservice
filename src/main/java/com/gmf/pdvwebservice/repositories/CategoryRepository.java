package com.gmf.pdvwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmf.pdvwebservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
