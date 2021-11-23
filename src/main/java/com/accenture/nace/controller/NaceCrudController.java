package com.accenture.nace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.nace.model.NaceOrder;
import com.accenture.nace.service.NaceService;

@RestController
public class NaceCrudController {
	
	@Autowired
	private NaceService service;
	
	@PostMapping("/bookorder")
	public ResponseEntity<NaceOrder> bookOrder(@RequestBody NaceOrder order) {
		NaceOrder bookorder  = service.saveOrder(order);
		return new ResponseEntity<NaceOrder> (bookorder, HttpStatus.CREATED);
	}
	
	@PostMapping("/bookorders")
	public ResponseEntity<List<NaceOrder>> bookOrders(@RequestBody List<NaceOrder> orders){
		List<NaceOrder> bookOrders =  service.saveOrders(orders);
		return new ResponseEntity<List<NaceOrder>> (bookOrders, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<NaceOrder>> getAllOrders() {
		List<NaceOrder> listOfOrders = service.getAllOrders();
		return new ResponseEntity<List<NaceOrder>> (listOfOrders, HttpStatus.OK);
	}
	
	@GetMapping("/order/{orderid}")
	public ResponseEntity<NaceOrder> findOrderByID(@PathVariable Integer orderid) {
		NaceOrder findbyID = service.getNaceOrderByID(orderid);
		return new ResponseEntity<NaceOrder> (findbyID, HttpStatus.OK);
	}
	
	@PutMapping("/update-order")
	public ResponseEntity<NaceOrder> updatOrder(@RequestBody NaceOrder order) {
		NaceOrder update= service.updateOrder(order);
		return new ResponseEntity<NaceOrder> (update, HttpStatus.CREATED);
	}

}
