package ladderline;

import java.util.ArrayList;

public class Ladder {

	ArrayList<Line> lines = new ArrayList<Line>();

	public ArrayList<Line> getLadder() {
		return lines;
	}

	public void setLadder(ArrayList<Line> ladder) {
		this.lines = ladder;
	}

	/**
	 * 전체 사다리 틀을 만들기
	 * 
	 * @param n
	 * @return
	 */
	public void initLadder(int n) {
		// n은 시작점 갯수를 의미,
		for (int i = 0; i < n; i++) {
			Line line = new Line();
			line.initLine(i, n);
			lines.add(line);
		}
		coloringLadder();

	}

	public void coloringLadder() {
		for (int i = 0; i < lines.size(); i++) {
			if (i == lines.size() - 1) {
				for (int j = 0; j < lines.size(); j++) {
					lines.get(i).getBoxLine().get(j).setColored(false);
				}
				break;
			}

			for (int j = 0; j < lines.size(); j++) {
				//이미 왼쪽 줄에 색이 칠해져 있으면 자신의 칸에는 칠하지 않는다. 
				if(i != 0 && lines.get(i-1).getBoxLine().get(j).isColored())
					continue;
				
				int range = (int) (Math.random() * 10);// 괄호 위치; 때문에 계속 1나옴. 어떤
														// 원리인지 기억할 것.
				if (range < 5 && range >= 0) {
					lines.get(i).getBoxLine().get(j).setColored(true);
				} else {
					lines.get(i).getBoxLine().get(j).setColored(false);
				}
			}

		}

	}

}
