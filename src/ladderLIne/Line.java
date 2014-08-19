package ladderline;

import java.util.ArrayList;
//세로 줄 만들기 
public class Line {
	ArrayList<Box> boxLine = new ArrayList<Box> ();		
	
//	public Line(ArrayList<Box> boxLine){
//		this.boxLine = boxLine;
//	}
	
	public ArrayList<Box> getBoxLine() {
		return boxLine;
	}
	public void setBoxLine(ArrayList<Box> boxLine) {
		this.boxLine = boxLine;
	}
	
	
	
	/**
	 * line에 박스를 채우는 init 작업. 
	 * @param columnNum
	 * @param n
	 */
	public void initLine(int columnNum, int n){
		for(int i = 0 ; i < n; i++){
			Box box = new Box(columnNum, i);
			boxLine.add(box);
			
		}
	}
}
