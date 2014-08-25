package ladderline;

public class Box {
	/**
	 * 특별한 경우가 아니면 field 접근 제어자는 private으로 구현 - javajigi
	 * check
	 */
	private boolean colored;
	private int x, y;
	
	public Box(int x, int y){
		this.x= x;
		this.y = y;
	}
	public Box(boolean colored, int x, int y){
		this.colored = colored;
		this.x= x;
		this.y = y;
	}

	public boolean isColored() {
		return colored;
	}

	public void setColored(boolean colored) {
		this.colored = colored;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	



}


