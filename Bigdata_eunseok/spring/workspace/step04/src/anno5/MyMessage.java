package anno5;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
//@Service
@Repository
@Scope("singleton")
public class MyMessage {
	private String message;
	
	public MyMessage() {
		message = "즐겁게 삽시다.";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
