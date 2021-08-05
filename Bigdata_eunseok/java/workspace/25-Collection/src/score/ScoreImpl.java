package score;

import java.util.*;

public class ScoreImpl implements Score {
	List<ScoreVO> list = new ArrayList<ScoreVO>();
	Scanner s = new Scanner(System.in);
	
	@Override
	public void input() {
		ScoreVO vo = new ScoreVO();
		System.out.print("�й� : ");
		vo.setStudent_num(s.next());
		System.out.print("�̸� : ");
		vo.setStudent_name(s.next());
		System.out.print("���� : ");
		vo.setKor(s.nextInt());
		System.out.print("���� : ");
		vo.setEng(s.nextInt());
		System.out.print("���� : ");
		vo.setMat(s.nextInt());
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		vo.setTot(tot);
		vo.setAvg(tot / 3.0);
		
		list.add(vo);
	}

	@Override
	public void print() {
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			ScoreVO vo = list.get(i);
			System.out.println(vo.toString());
		}
	}

	@Override
	public void printTitle() {
		String str = String.format("%7s %6s %4s%4s %3s %3s %3s",
									"�й�", "�̸�", "����", "����", "����", "����", "���");
		System.out.println(str);
	}

	@Override
	public void serchStudentNum() {
		System.out.print("�й� �Է� : ");
		String n = s.next();
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			ScoreVO vo = list.get(i);
			if(n.equals(vo.getStudent_num())) {
				System.out.println(vo.toString());
			}
		}
	}

	@Override
	public void serchName() {
		System.out.print("�̸� �Է� : ");
		String n = s.next();
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			ScoreVO vo = list.get(i);
			if(n.equals(vo.getStudent_name())) {
				System.out.println(vo.toString());
			}
		}
	}

	@Override
	public void descSortTot() {
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getTot() < vo2.getTot() ? 1 : -1;
			}
		};
		Collections.sort(list, comp);
		print();
	}

	@Override
	public void ascSortStudentNum() {
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				return vo1.getStudent_num().compareTo(vo2.student_num);
			}
		};
		
		Collections.sort(list, comp);
		print();
	}
	
	@Override
	public void saveFile() {
		ObjectInOut inout = new ObjectInOut();
		inout.write("score.txt", list);
	}
	
	@Override
	public void loadFile() {
		ObjectInOut inout = new ObjectInOut();
		list = inout.read("score.txt");
	}
}
