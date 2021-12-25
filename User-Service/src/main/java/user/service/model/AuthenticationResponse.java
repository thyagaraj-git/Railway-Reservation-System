package user.service.model;

public class AuthenticationResponse {

	private String Response;

	public AuthenticationResponse() {
		
	}
	

	public AuthenticationResponse(String response) {
	
		Response = response;
	}


	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}
	
	
}
