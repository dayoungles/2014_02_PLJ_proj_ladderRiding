package ladderline;

import java.util.ArrayList;

public class Ladder {
	
	ArrayList<Line> ladder = new ArrayList<Line>();
	
	public ArrayList<Line> getLadder() {
		return ladder;
	}

	public void setLadder(ArrayList<Line> ladder) {
		this.ladder = ladder;
	}

	/**
	 * 전체 사다리 틀을 만들기 
	 * @param n
	 * @return
	 */
	public ArrayList<Line> makeLadder(int n){
		//n은 시작점 갯수를 의미,
		for (int i = 0; i < n; i++ ){
			Line line = new Line();
			line.initLine(i, n);
			ladder.add(line);
		}
		return ladder;
	}
	
	
}
