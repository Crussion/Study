package test02;

import org.springframework.context.support.GenericXmlApplicationContext;


public class jdbcExample2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean2.xml");
		
		GoodsService service = (GoodsService) context.getBean("goodsService");
		
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0001");
		
		int result = service.deleteGoods(vo);
		
		if(result > 0) {
			System.out.println(vo.getCode() + "교재가 삭제 되었습니다.");
			for(GoodsVO gvo : service.getGoodsList()) {
				System.out.println("---> " + gvo.toString());
			}
		}else {
			System.out.println("삭제 실패");
		}
		
		context.close();
	}
}
