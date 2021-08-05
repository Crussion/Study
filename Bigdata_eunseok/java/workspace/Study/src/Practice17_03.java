class DrawData{
	private int height;
	private char character;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public void draw() {}
}
class IsoTriangle extends DrawData{
	public void draw() {
		for(int i = 1; i <= getHeight(); i++) {
			for(int j = 0; j < i; j++)
				System.out.print(getCharacter());
			System.out.println();
		}
	}
}
class Pyramid extends DrawData{
	public void draw() {
		for(int i = 1; i <= getHeight(); i++) {
			for(int j = 0; j < getHeight() - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < i + (i - 1); j++) {
				System.out.print(getCharacter());
			}
			System.out.println();
		}
	}
}
public class Practice17_03 {
	public static void main(String[] args) {
		DrawData drawData;
		
		drawData = new IsoTriangle();
		drawData.setHeight(10);
		drawData.setCharacter('x');
		drawData.draw();
		
		drawData = new Pyramid();
		drawData.setHeight(10);
		drawData.setCharacter('#');
		drawData.draw();
	}
}
