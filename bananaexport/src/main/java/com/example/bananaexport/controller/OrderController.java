package com.example.bananaexport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bananaexport.entity.Order;
import com.example.bananaexport.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(path = "orders/{id}")
	public List<Order> getOrdersByReceiverId(@PathVariable Long id) {
		return orderService.getOrdersByCompanyId(id);
	}

	@PostMapping(path = "orders")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	@PutMapping(path = "orders/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		return orderService.updateOrder(id, order);
	}
	
	@DeleteMapping(path="orders/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
	}

}
