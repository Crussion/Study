package score.controller;

import java.util.HashMap;
import java.util.Map;

// Map 클래스 : Model 저장
// (요청 정보, 동작 controller 객체)
public class HandlerMapping {
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		map = new HashMap<String, Controller>();
		map.put("/scoreWrite.do", new ScoreWriteController());
		map.put("/scoreList.do", new ScoreListController());
		map.put("/scoreView.do", new ScoreViewController());
		map.put("/scoreWriteForm.do", new ScoreWriteFormController());
		map.put("/scoreDelete.do", new ScoreDeleteController());
	}
	
	public Controller getController(String path) {
		return map.get(path);
	}
}
