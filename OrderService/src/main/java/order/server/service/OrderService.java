package order.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import order.server.repository.OrderRepository;

public class OrderService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderRepository orderRepo;
	
	
}
