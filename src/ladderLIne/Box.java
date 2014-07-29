package ladderLIne;

public class Box {
	boolean colored;
	Position pos;
	
	public Box(boolean colored, int x, int y){
		this.colored = colored;
		pos.setPosX(x);
		pos.setPosY(y);
	}

	public boolean isColored() {
		return colored;
	}

	public void setColored(boolean colored) {
		this.colored = colored;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}


