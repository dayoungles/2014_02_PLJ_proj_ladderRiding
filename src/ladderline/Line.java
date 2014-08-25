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
	 * line 한줄을 인자로 받아서 모두 false로 설정하는 함수. 리팩토링.
	 * 이런 의도가 맞나여?
	 * @param line
	 */
	public void setLastLine() {
		for(int i = 0; i < boxLine.size(); i++){
			boxLine.get(i).setColored(false);
		}
		
	}
	
	public void randomColoring(){
		for(int i = 0; i< boxLine.size(); i++){
			 Box box= boxLine.get(i);//요거 박스임. 
				int range = (int) (Math.random() * 10);// 괄호 위치; 때문에 계속 1나옴. 어떤 원리인지 기억할 것.
				if (range < 5 && range >= 0) {
					box.setColored(true);
				} else {
					box.setColored(false);
				}
			
		}
	}
	
	/**
	 * 라인안의 박스넘버를 param으로 받아서 그 박스가 색칠되었는지 확인. 
	 * @param boxNum
	 * @return
	 */
	public boolean checkBoxColored (int boxNum){
			return boxLine.get(boxNum).isColored();			
	}
	
	
	/**
	 * 이런 함수까지도 필요할까요??
	 * @param boxNum
	 */
	public void setBoxColor(int boxNum){
		boxLine.get(boxNum).setColored(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
