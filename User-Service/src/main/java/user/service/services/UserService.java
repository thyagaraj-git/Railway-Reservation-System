package user.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import user.service.UserRepository.UserRepository;
import user.service.model.UserLog;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLog founduser = userRepo.findByUsername(username);
		if (founduser == null) return null;
		
		String name = founduser.getUsername();
		String pass = founduser.getPassword();
		
		return new User(name,pass,new ArrayList<>());
	}

}
