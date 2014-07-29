package ladderLIne;

import java.util.ArrayList;
//세로 줄 만들기 
public class Line {
	ArrayList<Box> boxLine = new ArrayList<Box> ();		

	//line에 박스를 채우는 작업. 컬러 색칠 안함. 
	public void setLine(int columnNum, int n){
		for(int i = 0 ; i < n; i++){
			Box box = new Box(columnNum, i);
			boxLine.add(box);
		}
	}
	
	public ArrayList<Box> getLine(){
		return boxLine;
	}
}
