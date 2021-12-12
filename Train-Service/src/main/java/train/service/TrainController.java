package train.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import train.service.model.Trains;
import train.service.repo.TrainRepository;



@RestController
@RequestMapping("/adminControl")
public class TrainController {

	@Autowired
	private TrainRepository trainrepo;
//	@Autowired
//	private TrainService trainservice;
	
	@PostMapping("/addTrain")
	public String saveTrain(@RequestBody Trains trainid) {
	trainrepo.save(trainid);
	return "Added train with id :  " + trainid.getTrainid();
    }
	
	@GetMapping("{trainid}")
	public Optional<Trains> getTrain(@PathVariable String trainid){
		return trainrepo.findById(trainid);
	}
	
	 @GetMapping("/findAllTrains")
	    public List<Trains> getTrains(){
		return trainrepo.findAll();
		
	}
//	    @GetMapping("/findbyId/{trainid}")
//	    public Optional<Trains> getTrains(@PathVariable String trainid){
//		return trainrepo.findById(trainid);
//	}
	
	@DeleteMapping("/delete/{trainid}")
	public String deleteTrain (@PathVariable String trainid) {
		trainrepo.deleteById(trainid);
		return "Train deleted with id : "+trainid;
    }
	@PutMapping("/update/{trainid}")
	public Trains updateTrain(@PathVariable("trainid") String trainid,@RequestBody Trains t ) {
		t.setTrainid(trainid);
		trainrepo.save(t);
		return t;
		
}
}
