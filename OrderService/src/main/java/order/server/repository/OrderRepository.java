package order.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import order.server.model.BookingOrder;

public interface OrderRepository extends MongoRepository<BookingOrder,String>{

	
	
}
