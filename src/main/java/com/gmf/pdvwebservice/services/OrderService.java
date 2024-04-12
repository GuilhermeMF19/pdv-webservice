package com.gmf.pdvwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gmf.pdvwebservice.entities.Order;
import com.gmf.pdvwebservice.repositories.OrderRepository;
import com.gmf.pdvwebservice.services.exceptions.DatabaseException;
import com.gmf.pdvwebservice.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Order entity, Order obj) {
		entity.setMoment(obj.getMoment());
		entity.setOrderStatus(obj.getOrderStatus());
		entity.getItems().clear();
	    entity.getItems().addAll(obj.getItems());

	    if (obj.getPayment() != null) {
	        if (entity.getPayment() != null) {
	            entity.getPayment().setOrder(null);
	        }
	        obj.getPayment().setOrder(entity); 
	        entity.setPayment(obj.getPayment()); 
	    } else {
	        entity.setPayment(null);
	    }
	}
}
