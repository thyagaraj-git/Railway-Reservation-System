package adminservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import adminservice.model.Trains;

//import adminservice.service.service;
@RestController
//@RequestMapping("/admin")
public class adminController {
	
	

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/admin/{Id}")
	public Trains getTrain(@PathVariable String Id) {
		Trains traindetails= restTemplate.getForObject("http://localhost:8092/adminControl/"+Id	, Trains.class);
				return traindetails;
	}
	
	
	@RequestMapping(value="/admin/create",method = RequestMethod.POST)
	public String create(@RequestBody Trains train) {
		 HttpEntity<Trains> entity = new HttpEntity<Trains>(train);
		 String addTrain= restTemplate.exchange("http://localhost:8092/adminControl/addTrain", HttpMethod.POST, entity, String.class).getBody();
		 return addTrain;
	}

	
	   @RequestMapping(value = "/admin/update/{id}", method = RequestMethod.PUT) 
	   public String updateTrain(@PathVariable("id") String id, @RequestBody Trains train) {
	      return restTemplate.postForObject(
	         "http://localhost:8092/adminControl/update/"+id, train, String.class);
	   }
	   
	   
	   @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.DELETE)
	   public Boolean deleteTrain(@PathVariable("id") String id) {
	      restTemplate.delete(
	         "http://localhost:8092/adminControl/delete/"+id );
	      return true;
	   }
	}
