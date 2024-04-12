package com.gmf.pdvwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmf.pdvwebservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
