package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.dto.DbtestDTO;

public class Exam6 {
	public static void main(String[] args) {
		DbtestDAO dao = new DbtestDAO();
		
		//insert
		int result = dao.insertArticle();
		if(result > 0) System.out.println("저장 성공");
		else System.out.println("저장 실패");
		System.out.println();
		
		//select
		List<DbtestDTO> list = dao.selectArticle();
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
		System.out.println();
		
		//update
		result = dao.updateArticle();
		if(result > 0) System.out.println(result + "개의 데이터 수정됨");
		else System.out.println("수정 실패");
		
		list = dao.selectArticle();
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
		
		//delete
		result = dao.deleteArticle();
		if(result > 0) System.out.println(result + "개의 데이터 삭제됨");
		else System.out.println("삭제 실패");
		
		list = dao.selectArticle();
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
	}
}
