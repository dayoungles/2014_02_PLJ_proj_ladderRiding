package ladderline;

import java.util.ArrayList;
import java.util.Random;

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
		coloringLadder(n);

	}

	public void coloringLadder(int startNum) {
		
		/*
		   //출발 인원을 10명 이상 늘리면 0번 라인은 거의 1번 아니면 2번에 떨어지는 확률이 나옴. 
		   //문제가 있다고 생각해서 로직 수정. 
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
				if (range < 3 && range >= 0) {
					lines.get(i).getBoxLine().get(j).setColored(true);
				} else {
					lines.get(i).getBoxLine().get(j).setColored(false);
				}
			}
		}
		*/
		int setLineNum = startNum*2;
		for(int i = 0; i < setLineNum; i++){
			boolean leftColored = false, rightColored= false;
			
			Random random = new Random();
			int randomX = random.nextInt(startNum);
			int randomY = random.nextInt(startNum);
			System.out.println(randomX+ " "+ randomY);
			if(randomX == startNum-1){
				continue;
			}
			if(randomX !=0){
				 leftColored= lines.get(randomX-1).getBoxLine().get(randomY).isColored();
			}
			if(randomX != startNum-1){
				 rightColored = lines.get(randomX+1).getBoxLine().get(randomY).isColored();
			}
			while(leftColored || rightColored){
				randomX = random.nextInt(startNum);
				randomY = random.nextInt(startNum); 
				if(randomX !=0){
					 leftColored= lines.get(randomX-1).getBoxLine().get(randomY).isColored();
				}
				if(randomX != startNum-1){
					 rightColored = lines.get(randomX+1).getBoxLine().get(randomY).isColored();
				}
			}
			lines.get(randomX).getBoxLine().get(randomY).setColored(true);
			
		}
		

	}

}
