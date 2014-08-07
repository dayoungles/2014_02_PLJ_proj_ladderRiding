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

	/**
	 * 박스가 채워진 arrayList에 랜덤으로 박스를 컬러링. 
	 * @param boxLine
	 */
	public void coloringLine(){
		for(int i = 0; i < boxLine.size(); i++){
			if(i!= boxLine.size()-1){
				int range = (int)(Math.random()*10);//괄호 위치; 때문에 계속 1나옴. 어떤 원리인지 기억할 것.
				if(range < 5 && range >=0){
					boxLine.get(i).setColored(true);//0~4 사이의 숫자가 걸리면 색칠.
					continue;
				}
			} 
			
			boxLine.get(i).setColored(false);//마지막 줄은 전부다 false 
			
		}
	}
	
}
