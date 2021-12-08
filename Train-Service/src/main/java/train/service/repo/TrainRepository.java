package train.service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import train.service.model.Trains;



public interface TrainRepository extends MongoRepository<Trains,String>{

}
