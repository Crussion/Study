package anno6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// bean.xml과 같은 기능의 클래스
@Configuration
public class AppConfig {
	// bean 객체 설정
	// <bean id="myService" class="anno6.UserServiceImpl">
	@Bean
	public UserService myService() {
		return new UserServiceImpl();
	}
}
