package train.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import train.service.model.Trains;
import train.service.repo.TrainRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TrainServiceApplicationTests {

	@Autowired
	TrainRepository trainRepo;
	
	@Test
	@Order(1)
	public void TestAdd() {
		Trains t=new Trains("1","train1","mumbai","bangalore",2500); 
		Trains t1=new Trains("22","train2","chennai","bangalore",1500); 
		trainRepo.save(t);
		trainRepo.save(t1);
		assertNotNull(trainRepo.findById("1").get());
	}
	
	@Test
	@Order(2)
	public void testFindall() {
		List<Trains> list=trainRepo.findAll();
		//assertThat(list).size().isGreaterThan(0);
		assertEquals(5,list.size());
	}
	
	@Test
	@Order(3)
	public void testbyId() {
		Trains train=trainRepo.findById("1").get();
		assertEquals(2500,train.getFare());
	}
	
	@Test
	@Order(4)
	public void testupdate() {
		Trains train=trainRepo.findById("1").get();
		train.setFare(2300);
		trainRepo.save(train);
		assertEquals(2300,trainRepo.findById("1").get().getFare());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		trainRepo.deleteById("1");
		assertThat(trainRepo.existsById("1")).isFalse();
	}
}
