package test.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	Scanner s = new Scanner(System.in);
	@Autowired
	GoodsDAO dao;
	@Override
	public int insertGoods(GoodsVO vo) {
		return dao.insertGoods(vo);
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		return dao.updateGoods(vo);
	}

	@Override
	public int deleteGoods(GoodsVO vo) {
		return dao.deleteGoods(vo);
	}

	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return dao.getGoods(vo);
	}

	@Override
	public List<GoodsVO> getGoodsList() {
		return dao.getGoodsList();
	}
	
	@Override
	public int menu() {
		System.out.println("1. 입력");
		System.out.println("2. 출력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		
		System.out.println("-----------");
		System.out.print("번호 : ");
		int c = s.nextInt();
		System.out.println();
		return c;
	}
	
	@Override
	public GoodsVO input() {
		GoodsVO vo = new GoodsVO();
		System.out.print("코드 : ");
		String code = s.next();
		System.out.print("제목 : ");
		String name = s.next();
		System.out.print("가격 : ");
		int price = s.nextInt();
		System.out.print("출판사 : ");
		String maker = s.next();
		
		vo.setCode(code);
		vo.setName(name);
		vo.setPrice(price);
		vo.setMaker(maker);
		
		return vo;
	}
	
	@Override
	public GoodsVO update_input() {
		GoodsVO vo = new GoodsVO();
		
		System.out.print("수정할 코드 : ");
		String code = s.next();
		System.out.print("수정할 제목 : ");
		String name = s.next();
		System.out.print("수정할 가격 : ");
		int price = s.nextInt();
		System.out.print("수정할 출판사 : ");
		String maker = s.next();
		
		vo.setCode(code);
		vo.setName(name);
		vo.setPrice(price);
		vo.setMaker(maker);
		
		return vo;
	}
	
	@Override
	public GoodsVO delete_input() {
		GoodsVO vo = new GoodsVO();
		
		System.out.print("삭제할 코드 : ");
		String code = s.next();
		
		vo.setCode(code);
		
		return vo;
	}
	
	@Override
	public int chooseView() {
		System.out.println("1. 검색");
		System.out.println("2. 전체 출력");
		System.out.println("-----------");
		System.out.print("번호 : ");
		int c = s.nextInt();
		System.out.println();
		return c;
	}
	
	@Override
	public GoodsVO serch() {
		GoodsVO vo = new GoodsVO();
		
		System.out.print("검색할 코드 : ");
		String code = s.next();
		
		vo.setCode(code);
		return vo;
	}
}
