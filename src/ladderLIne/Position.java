package ladderline;

public class Position {
	int x, y;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	public int getPosX (){
		return x;
	}
	public int getPosY (){
		return y;
	}
	public void setPosX(int x){
		this.x = x;
	}
	public void setPosY(int y){
		this.y = y;
	}
	
	public void setPosXY(int x, int y){
		this.x = x;
		this.y = y;
	}
}
