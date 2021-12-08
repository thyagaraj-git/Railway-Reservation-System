package train.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import train.service.model.Trains;
import train.service.repo.TrainRepository;

@RestController
@RequestMapping("/userSearch")
public class UserController {

	@Autowired
	private TrainRepository trainrepo;

    @GetMapping("/findAllTrains")
    public List<Trains> getTrains(){
	return trainrepo.findAll();
	
}
    @GetMapping("/findbyId/{trainid}")
    public Optional<Trains> getTrains(@PathVariable String trainid){
	return trainrepo.findById(trainid);
}
}
