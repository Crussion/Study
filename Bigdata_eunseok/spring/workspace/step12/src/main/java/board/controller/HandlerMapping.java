package board.controller;

import java.util.HashMap;
import java.util.Map;

// Map 클래스 : Model 저장
// (요청 정보, 동작 controller 객체)
public class HandlerMapping {
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		map = new HashMap<String, Controller>();
		map.put("/login.do", new LoginController());
		map.put("/boardList.do", new BoardListController());
		map.put("/boardWriteForm.do", new BoardWriteFormController());
		map.put("/boardWrite.do", new BoardWriteController());
		map.put("/boardView.do", new BoardViewController());
		map.put("/boardDelete.do", new BoardDeleteController());
	}
	
	public Controller getController(String path) {
		return map.get(path);
	}
}
