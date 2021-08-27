package anno4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
	//@Autowired
	//@Qualifiler(value="student")
	@Resource(name="student")
	private Student person;
	//@Autowired
	//@Qualifiler(value="grade")
	@Resource(name="grade")
	private int grade;
	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
}
