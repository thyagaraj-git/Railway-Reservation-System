package user.service.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import io.swagger.annotations.Api;
import user.service.model.BookingOrder;
import user.service.model.Trains;

@RestController
//@Api(tags = "Clients")
//@RequestMapping("/user")
public class userController {

	 @Autowired
	   RestTemplate restTemplate;

	 //---------------to access train data-----------------------------------//
	 
	 
	   @RequestMapping(value = "/user/getAll")
	   public List<Trains> getTrains() {
	      return Arrays.asList(restTemplate.getForObject("http://localhost:8092/adminControl/findAllTrains", Trains[].class));
	   }
	   
	   
	 //---------------to access orders-------------------------------------//
	   
	   
	   @RequestMapping(value = "/user/reserveForm", method = RequestMethod.POST)
	   public String create(@RequestBody BookingOrder order) {
	      return restTemplate.postForObject(
	         "http://localhost:8099/orders/addOrder", order, String.class);
	   }
	   
	   
	   
	   @RequestMapping(value="/user/{userId}")
		public BookingOrder getOrder(@PathVariable int userId) {
			BookingOrder order= restTemplate.getForObject("http://localhost:8099/orders/"+userId, BookingOrder.class);
					return order;
	   }
	   
	   
	   
	   @RequestMapping(value = "/user/deleteOrder/{id}", method = RequestMethod.DELETE)
	   public Boolean deleteOrder(@PathVariable("id") String id) {
	      restTemplate.delete(
	         "http://localhost:8099/orders/delete/"+id);
	      return true;
	   }
}
