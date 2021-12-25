package user.service.UserLogControl;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.service.UserRepository.UserRepository;
import user.service.model.AuthenticationRequest;
import user.service.model.AuthenticationResponse;
import user.service.model.UserLog;
import user.service.services.UserService;
import user.service.utils.JwtUtils;

@RestController
@RequestMapping("/userlog")
public class AuthController {

	//Logger log=LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/register")
	private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest authenticationRequest){
		String username= authenticationRequest.getUsername();
		String password= authenticationRequest.getPassword();
		UserLog userlog=new UserLog();
		userlog.setUsername(username);
		userlog.setPassword(password);
	    
		
	    try {
	    	userRepo.save(userlog);
	    	
	    }catch(Exception e){
	    	return ResponseEntity.ok(new AuthenticationResponse("error during subscription for user"+username));
	    }
		return ResponseEntity.ok(new AuthenticationResponse("successful subscription for user"+username));
	}
	
	
	
	@PostMapping("/login")
    private ResponseEntity<?> authentication(@RequestBody AuthenticationRequest authenticationRequest){
		String username= authenticationRequest.getUsername();
		String password= authenticationRequest.getPassword();
		
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(Exception e){
			return ResponseEntity.ok(new AuthenticationResponse("error during authentication for user"+username));
		}
	
		
		
		UserDetails loadedUser = userService.loadUserByUsername(username);
		
		String generateToken = jwtUtils.generateToken(loadedUser);
		
		return ResponseEntity.ok(new AuthenticationResponse(generateToken));
	}
	
}
