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
		coloringLadderByLine(n);
		coloringLadderByRandom(n);
		coloringBackUp(n);

	}
	
	/**
	 * 세로 라인별로 랜덤하게 사다리 줄을 긋는 함수. 
	 * @param startNum
	 */
	public void coloringLadderByLine(int startNum) {
		   //출발 인원을 10명 이상 늘리면 0번 라인은 거의 1번 아니면 2번에 떨어지는 확률이 나옴. 
		   //문제가 있다고 생각해서 로직 수정. 하려고 했으나 새로운 줄긋기 방식과 병행하기로. 
		for (int i = 0; i < lines.size(); i++) {
			
			//가장 마지막 사다리는 줄을 긋지 않기 위해서 전부 false로 처리. 
			if (i == lines.size() - 1) {
				for (int j = 0; j < lines.size(); j++) {
					lines.get(i).getBoxLine().get(j).setColored(false);
				}
				break;
			}
			//칸별로 랜덤하게 줄을 그을지 선택.  
			for (int j = 0; j < lines.size(); j++) {
				//이미 왼쪽 줄에 색이 칠해져 있으면 자신의 칸에는 칠하지 않는다. 
				if(i != 0 && lines.get(i-1).getBoxLine().get(j).isColored())
					continue;
				int range = (int) (Math.random() * 10);// 괄호 위치; 때문에 계속 1나옴. 어떤 원리인지 기억할 것.
				if (range < 5 && range >= 0) {
					lines.get(i).getBoxLine().get(j).setColored(true);
				} else {
					lines.get(i).getBoxLine().get(j).setColored(false);
				}
			}
		}
	}
	/**
	 *  byLine은 매 한 칸 별로 랜덤하게 선택했다면, 이 함수는 전체 사다리 중에서 랜덤하게 
	 *  박스를 골라서 출발 인원만큼 색칠한다.잘 섞이게 하기 위해서 하나 더 줄긋는 방식을 추가. 
	 * @param startNum
	 */
	public void coloringLadderByRandom(int startNum){
		
		for(int i = 0; i < startNum; i++){
			boolean leftColored = false, rightColored= false;
			
			Random random = new Random();
			int randomX = random.nextInt(startNum-2);//전체 개수-1(0에서 시작하니까) -1(마지막줄 그으면 안되니까)
			int randomY = random.nextInt(startNum);
			

			boolean checkSelf = lines.get(randomX).getBoxLine().get(randomY).isColored();
			if(checkSelf){//자기 자리에 이미 선 있는지 확인
				i--;
				continue;
			}
			if(randomX !=0){//엑스 축이 0이 아니면 그 왼쪽 박스에 선이 있는지 확인
				 leftColored= lines.get(randomX-1).getBoxLine().get(randomY).isColored();
			}
			if(randomX <= startNum-2){//엑스 축이 제일 오른쪽에서 -1칸이면 그 오른쪽 박스가 선이 있는지 확인. 
				 rightColored = lines.get(randomX+1).getBoxLine().get(randomY).isColored();
			}
			while(leftColored || rightColored){//둘 중 하나라도 선이 있으면 다시 선을 그을 박스를 확인한다. 여기 바꿀 방법을 코드 리뷰 받아야 할 
				randomX = random.nextInt(startNum-2);
				randomY = random.nextInt(startNum); 
				if(randomX !=0){
					 leftColored= lines.get(randomX-1).getBoxLine().get(randomY).isColored();
				}
				if(randomX <= startNum-2){
					 rightColored = lines.get(randomX+1).getBoxLine().get(randomY).isColored();
				}

			}
			lines.get(randomX).getBoxLine().get(randomY).setColored(true);
			
		}
	}
	
	/**
	 * 사다리를 랜덤으로 그리다보니 세로라인에 줄을 하나도 안 그렀을 때를 방지.
	 * @param num
	 */
	public void coloringBackUp(int num) {
		for(int i =0; i < num-1; i++){
			boolean checkLine = false;
			for(int j =0; j < num-1; j++){
				boolean checkColor= lines.get(i).getBoxLine().get(j).isColored();
				if(checkColor){
					checkLine = true;
					break;
				}
			}
			if(!checkLine){
				lines.get(i).getBoxLine().get(i).setColored(true);
			}
		}
	}

}
