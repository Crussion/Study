package test.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.GoodsVO;
import test.service.GoodsService;

public class HelloSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		GoodsService service = (GoodsService) context.getBean("goodsService");
		while(true) {
			int c = service.menu();
			if(c == 1) {
				GoodsVO vo = service.input();
				int result = service.insertGoods(vo);
				if(result > 0) {
					System.out.println("입력 성공");
				}else {
					System.out.println("입력 실패");
				}
				System.out.println();
			}else if(c == 2) {
				int cc = service.chooseView();
				if(cc == 1) {
					GoodsVO vo = service.serch();
					vo = service.getGoods(vo);
					if(vo != null)
						System.out.println("---> " + vo.toString());
					else
						System.out.println("존재 하지 않는 코드입니다.");
				}else if(cc == 2) {
					List<GoodsVO> list = service.getGoodsList();
					for(GoodsVO vo: list) {
						System.out.println("---> " + vo.toString());
					}
				}else {
					System.out.println("잘못된 입력입니다.");
				}
				System.out.println();
			}else if(c == 3) {
				GoodsVO vo = service.update_input();
				int result = service.updateGoods(vo);
				if(result > 0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
			}else if(c == 4) {
				GoodsVO vo = service.delete_input();
				int result = service.deleteGoods(vo);
				if(result > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				System.out.println();
			}else if(c == 5) {
				System.out.println("시스템이 종료됩니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
				System.out.println();
			}
		}
		context.close();
	}
}
