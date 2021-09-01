package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.service.ScoreService;

public class HelloSpring {
	Scanner s = new Scanner(System.in);
	
	ScoreService service;
	
	public ScoreService getService() {
		return service;
	}

	public void setService(ScoreService service) {
		this.service = service;
	}

	public void menu() {
		while(true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			
			System.out.println("-----------");
			System.out.print("번호 : ");
			int c = s.nextInt();
			System.out.println();
			
			switch(c) {
			case 1:
				insert();
				break;
			case 2:
				out();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다");
				System.out.println();
			}
		}
	}
	
	public void insert() {
		ScoreVO vo = new ScoreVO();
		System.out.print("학생코드 : ");
		String studNo = s.next();
		System.out.print("이름 : ");
		String name = s.next();
		System.out.print("국어 : ");
		int kor = s.nextInt();
		System.out.print("영어 : ");
		int eng = s.nextInt();
		System.out.print("수학 : ");
		int mat = s.nextInt();
		
		int tot = kor + eng + mat;
		double avg = tot / 3.0;
		
		vo.setStudNo(studNo);
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		vo.setTot(tot);
		vo.setAvg(avg);
		
		int result = service.insertData(vo);
		if(result > 0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		System.out.println();
	}
	
	public void out() {
		while(true) {
			System.out.println("1. 검색");
			System.out.println("2. 전체 출력");
			System.out.println("-----------");
			System.out.print("번호 : ");
			int c = s.nextInt();
			System.out.println();
			
			if(c == 1) {
				ScoreVO vo = new ScoreVO();
				System.out.print("검색할 학생번호 : ");
				String studNo = s.next();
				vo.setStudNo(studNo);
				vo = service.getData(vo);
				if(vo != null)
					System.out.println("---> " + vo.toString());
				else
					System.out.println("존재 하지 않는 학생입니다.");
				System.out.println();
				break;
			}else if(c == 2) {
				List<ScoreVO> list = service.getList();
				if(list.size() > 0) {
					for(ScoreVO vo: list) {
						System.out.println("---> " + vo.toString());
					}
				}else {
					System.out.println("학생이 없습니다.");
				}
				System.out.println();
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
			System.out.println();
		}
	}
	
	public void update() {
		ScoreVO vo = new ScoreVO();
		System.out.print("수정할 학생번호 : ");
		String studNo = s.next();
		System.out.print("국어 : ");
		int kor = s.nextInt();
		System.out.print("영어 : ");
		int eng = s.nextInt();
		System.out.print("수학 : ");
		int mat = s.nextInt();
		
		int tot = kor + eng + mat;
		double avg = tot / 3.0;
		
		vo.setStudNo(studNo);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		vo.setTot(tot);
		vo.setAvg(avg);
		
		int result = service.updateData(vo);
		if(result > 0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
		System.out.println();
	}
	
	public void delete() {
		ScoreVO vo = new ScoreVO();
		System.out.print("삭제할 학생번호 : ");
		String studNo = s.next();
		
		vo.setStudNo(studNo);
		
		int result = service.deleteData(vo);
		if(result > 0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		HelloSpring spring = (HelloSpring) context.getBean("helloSpring");
		spring.menu();
	}
}
