package com.example.bananaexport.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bananaexport.exception.QuantityIsNotValidException;
import com.example.bananaexport.entity.Order;
import com.example.bananaexport.repository.OrderRepository;
import com.example.bananaexport.utils.OrderUtils;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getOrdersByCompanyId(Long id) {
		return orderRepository.findByCompanyId(id);
	}

	public Order addOrder(Order order) {
		boolean isQuantityValid = OrderUtils.isQuantityValid(order.getQuantity());

		if (isQuantityValid == false) {
			throw new QuantityIsNotValidException("The requested quantity is not valid");
		} else {

			Date deliveryDate = OrderUtils.calculateDeliveryDate();

			Order newOrder = new Order();
			newOrder.setDeliveryDate(deliveryDate);
			newOrder.setQuantity(order.getQuantity());
			newOrder.setCompanyId(order.getCompanyId());
			newOrder.setPrice(OrderUtils.calculateDeliveryPrice(order.getQuantity()));

			return orderRepository.save(newOrder);

		}

	}

	public Order updateOrder(Long id, Order order) {
		Optional<Order> orderInDb = orderRepository.findById(id);
		boolean isQuantityValid = OrderUtils.isQuantityValid(order.getQuantity());

		if (isQuantityValid == false) {
			throw new QuantityIsNotValidException("The requested quantity is not valid");
		} else {
			
			Order orderToUpdate = orderInDb.get();
			orderToUpdate.setPrice(OrderUtils.calculateDeliveryPrice(order.getQuantity()));
			orderToUpdate.setQuantity(order.getQuantity());
			
			return orderRepository.save(orderToUpdate);

		}
		
	}
	
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

}
