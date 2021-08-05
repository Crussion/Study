package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.dto.DbtestDTO;

public class Exam6 {
	public static void main(String[] args) {
		DbtestDAO dao = new DbtestDAO();
		
		//insert
		int result = dao.insertArticle();
		if(result > 0) System.out.println("���� ����");
		else System.out.println("���� ����");
		System.out.println();
		
		//select
		List<DbtestDTO> list = dao.selectArticle();
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
		System.out.println();
		
		//update
		result = dao.updateArticle();
		if(result > 0) System.out.println(result + "���� ������ ������");
		else System.out.println("���� ����");
		
		list = dao.selectArticle();
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
		
		//delete
		result = dao.deleteArticle();
		if(result > 0) System.out.println(result + "���� ������ ������");
		else System.out.println("���� ����");
		
		list = dao.selectArticle();
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
	}
}
