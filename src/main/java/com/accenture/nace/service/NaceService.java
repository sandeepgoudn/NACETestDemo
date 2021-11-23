package com.accenture.nace.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.nace.exception.EmptyInputException;
import com.accenture.nace.exception.NoResourceException;
import com.accenture.nace.model.NaceOrder;
import com.accenture.nace.repository.NaceRepository;

@Service
public class NaceService {

	@Autowired
	private NaceRepository repository;
	
	public NaceOrder saveOrder(NaceOrder order) {
		
		if(order.getDescription().isEmpty() || order.getDescription().length()<4) {
		throw new EmptyInputException("601", "Please enter proper description, description is less than 4 characters");
		}
		NaceOrder saveorder = repository.save(order);
		return saveorder;
		
	}

	public List<NaceOrder> saveOrders(List<NaceOrder> orders) {
		if(orders.get(0).getDescription().length()<4) {
			throw new EmptyInputException("601", "Please enter proper description, description is less than 4 characters");
			}
		return repository.saveAll(orders);
		
	}
	
	public List<NaceOrder> getAllOrders() {
		List<NaceOrder> allOrders = repository.findAll();
		if(allOrders.isEmpty()) {
			throw new NoResourceException("602", "There are no orders to display, please book/ add orders");
		}
		System.out.println("Getting data from DB: "+ allOrders);
		return allOrders;
		
	}
	
	public NaceOrder getNaceOrderByID(Integer orderid) {
		NaceOrder getbyid =repository.findById(orderid).orElse(null);
		return getbyid;
	}
	
	public NaceOrder updateOrder(NaceOrder order) {
		NaceOrder existingOrder = repository.findById(order.getOrderid()).orElse(null);
		if(existingOrder==null) {
			throw new NoSuchElementException("Order not found");
		}
		existingOrder.setCode(order.getCode());
		existingOrder.setDescription(order.getDescription());
		existingOrder.setLevel(order.getLevel());
		existingOrder.setParent(order.getParent());
		existingOrder.setThisitemincludes(order.getThisitemincludes());
		existingOrder.setThisitemsalsoincludes(order.getThisitemsalsoincludes());
		existingOrder.setExcludes(order.getExcludes());
		existingOrder.setRev4(order.getRev4());
		existingOrder.setRulings(order.getRulings());
		return repository.save(existingOrder);
	}
	


}
