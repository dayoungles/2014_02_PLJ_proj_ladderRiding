package ladderline;

import java.util.ArrayList;

public class Play {
	Ladder ladder = new Ladder();
	
	public static void main(String[] args){
		Play play = new Play();
		play.run();
		
	}
	void run(){
		//게임할 사람 수 입력
		int rowNum = 6;
		ladder.initLadder(rowNum);
		printLadder();
		//출발지 선택
		int start = 0;
		Position pos = new Position(start);
		System.out.println("출발: "+  pos.toString());
		for(int i = 0; i < rowNum; i++){
			pos = followLadder(pos);
			System.out.println(pos);
		}
		System.out.println(pos.getPosX()+"번으로 내려왔음 ");
	}
	
	public Position followLadder(Position pos){
		//포스가 가지고 있는 x, y값을 이용해서, 그 박스 의 colored 값을 확인
		//colored값에 따라서 움직임을 결정한다.  
		
		boolean boxColor= ladder.getLadder().get(pos.getPosX()).getBoxLine().get(pos.getPosY()).isColored();
		//사다리 y 축을 다 내려가면 끝나야한다. 
		
		if(boxColor){
			meetSelfColored(pos);
		} else {
			if(pos.getPosX()!=0 && ladder.getLadder().get(pos.getPosX()-1).getBoxLine().get(pos.getPosY()).isColored()){
				meetLeftColored(pos);
			} else{
				goDown(pos);
			}
		}
		return pos;
	}
	
	/**
	 * 자기 자신이 색칠돼 있을 때 오른쪽 아래로 옮겨줌. 
	 * @param pos
	 * @return
	 */
	public Position meetSelfColored(Position pos){
		pos.setPosXY(pos.getPosX()+1, pos.getPosY()+1);
		return pos;
	}
	
	/**
	 * 자기 왼쪽이 색칠돼 있을 때 왼쪽 아래로 옮겨줌.
	 * @param pos
	 * @return
	 */
	public Position meetLeftColored(Position pos){
		if(pos.getPosX() == 0)//제일 왼쪽 줄일 때는 왼쪽이 없기 때문에 체크 안함. 
			return pos;
		pos.setPosXY(pos.getPosX()-1, pos.getPosY()+1);
		return pos;
	}
	
	/**
	 * 둘다 색칠이 안돼 있을 떄, 아랫칸으로 옮겨줌. 
	 * @param pos
	 * @return
	 */
	public Position goDown(Position pos){
		pos.setPosY(pos.getPosY()+1);
		return pos;
	}
	
	void printLadder(){
		int n = ladder.getLadder().size();
		for(int j = 0; j < n; j++){
			for(int i = 0; i< n; i++){
				if(ladder.getLadder().get(i).getBoxLine().get(j).isColored()){
					System.out.print("|T");
				} else {
					System.out.print("|F");
				}
//				System.out.print("("+ladder.getLadder().get(i).getBoxLine().get(j).getX()
//				+" "+ladder.getLadder().get(i).getBoxLine().get(j).getY()+
//				" "+ ladder.getLadder().get(i).getBoxLine().get(j).isColored()
//						+")");
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
}
