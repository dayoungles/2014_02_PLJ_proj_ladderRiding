package ladderline;

import java.util.ArrayList;
//세로 줄 만들기 
public class Line {
	ArrayList<Box> boxLine = new ArrayList<Box> ();		
	
//	public Line(ArrayList<Box> boxLine){
//		this.boxLine = boxLine;
//	}

	//line에 박스를 채우는 init 작업. 
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
	public ArrayList<Box> coloringLine(ArrayList<Box> boxLine){
		for(int i = 0; i < boxLine.size(); i++){
			int range = (int)Math.random()*10;
			if(range < 5 && range >=0)
				boxLine.get(i).setColored(true);//0~4 사이의 숫자가 걸리면 색칠. 
			System.out.println(boxLine.get(i).isColored());
		}
		return boxLine;
	}
	
	public static void main(String[] args) {
		Line line = new Line();
		line.initLine(3, 5);
		
		line.coloringLine(line.boxLine);
	}
}
