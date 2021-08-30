package test.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.GoodsVO;
import test.service.GoodsService;

public class jdbcExample1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		GoodsService service = (GoodsService) context.getBean("goodsService");
		
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0003");
		vo.setName("Java");
		vo.setPrice(20000);
		vo.setMaker("한샘출판사");
		
		int result = service.insertGoods(vo);
		if(result > 0) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}
		
		List<GoodsVO> list = service.getGoodsList();
		for(GoodsVO goodsVO : list) {
			System.out.println("---> " + goodsVO.toString());
		}
	}
}
