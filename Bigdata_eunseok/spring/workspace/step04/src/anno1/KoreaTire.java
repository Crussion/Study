package anno1;

import org.springframework.stereotype.Component;

// <bean id="tire" class="anno1.KoreaTire"/> 과 동일
// 아이디를 생략하면, 기본값은 "koreaTire" => 소문자로 클레스명과 동일
@Component("tire")
public class KoreaTire implements Tire{
	@Override
	public String getBrand() {
		return "한국 타이어";
	}
}
