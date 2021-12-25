package order.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import order.server.model.BookingOrder;
import order.server.repository.OrderRepository;
import order.server.service.OrderService;

@RestController
public class BookingController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderRepository orderRepository;

	@PostMapping("/orders/addOrder")
	public String saveBook(@RequestBody BookingOrder book) {
	orderRepository.save(book);
	return book.getId();
    }

	
	@GetMapping("/orders")
	public List<BookingOrder> getAllTrains(){
		return orderRepository.findAll();
	}
	
	
	@GetMapping("/orders/{id}")
	public Optional<BookingOrder> getBook(@PathVariable String id){
		return orderRepository.findById(id);
	}
	
	
	@PutMapping("/orders/update/{id}")
	public BookingOrder updateOrder(@PathVariable("id") String id,@RequestBody BookingOrder order ) {
		order.setId(id);
		orderRepository.save(order);
		return order;
	}
	
		
	 @DeleteMapping("/orders/delete/{id}")
	 public String deleteOrder (@PathVariable String id) {
	  orderRepository.deleteById(id);
		return null;
		}
}
