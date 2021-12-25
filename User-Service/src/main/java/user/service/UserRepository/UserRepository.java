package user.service.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;


import user.service.model.UserLog;

@Repository
public interface UserRepository extends MongoRepository<UserLog,String>{

	UserLog findByUsername(String username);
}
