package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
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
	
}
