package ladderline;

public class Position {
	int x, y;
	
	public Position(int startPoint) {
		x = startPoint;
		y = 0;
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

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
