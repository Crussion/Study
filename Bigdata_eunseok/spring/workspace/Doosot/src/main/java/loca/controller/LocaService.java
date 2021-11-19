package loca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import event.bean.EventDTO;
import loca.bean.LocaDTO;

public interface LocaService {
	
	// 목록 10개씩 보기
	public List<LocaDTO> locaList(int startNum, int endNum) ;
	
	// 주소 검색 -> 주소에 00시, 00구 있을경우 찾기
	public List<LocaDTO> locaListSearch(int startNum, int endNum, String sido, String gugun);
	
	//검색 데이터 수
	public int getTotalS(String sido, String gugun);
	
	// 글 작성
	public int locaWrite(LocaDTO locaDto) ;
	
	// 총 데이터 수
	public int getTotalA() ;
	
	// 상세 보기
	public EventDTO locaView(int loca_num) ;
	
	// 삭제 하기
	public int locaDelete(int loca_num) ;
	
	// 수정하기
	public int locaCorr(LocaDTO locaDto) ;
}
