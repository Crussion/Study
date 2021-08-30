package test.service;

import java.util.List;

import test.bean.GoodsVO;

public interface GoodsService {
	public int insertGoods(GoodsVO vo);
	
	public int updateGoods(GoodsVO vo);
	
	public int deleteGoods(GoodsVO vo);
	
	public GoodsVO getGoods(GoodsVO vo);
	
	public List<GoodsVO> getGoodsList();
	
	public int menu();
	
	public GoodsVO input();
	
	public GoodsVO delete_input();
	
	public GoodsVO update_input();
	
	public int chooseView();
	
	public GoodsVO serch();
}
