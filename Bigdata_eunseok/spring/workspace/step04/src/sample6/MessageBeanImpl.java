package sample6;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("messageBean")
public class MessageBeanImpl implements MessageBean{
	@Autowired
	@Value("홍길동")
	private String name;
	@Autowired
	@Value("010-1234-5678")
	private String phone;
	@Autowired
	private Outputter outputter;
	
	public MessageBeanImpl() {}
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	
	@Override
	public void helloCall() {
		String message = name + " : " + phone;
		System.out.println(message);
		
		try {
			outputter.output(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
