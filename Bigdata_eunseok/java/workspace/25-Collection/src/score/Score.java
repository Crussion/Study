package score;

public interface Score {
	void input();
	void print();
	void printTitle();
	void serchStudentNum();
	void serchName();
	void descSortTot();
	void ascSortStudentNum();
	
	//27 - 파일 저장 불러오기 추가
	void saveFile();
	void loadFile();
}
