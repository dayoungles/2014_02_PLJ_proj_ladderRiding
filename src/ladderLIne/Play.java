package ladderline;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	Ladder ladder = new Ladder();
	
	public static void main(String[] args){
		Play play = new Play();
		Scanner scan = new Scanner(System.in);
		System.out.println("게임할 인원 수를 입력(숫자만)");
		String input= scan.nextLine();
		ArrayList<Position> forPrint= play.run(Integer.parseInt(input));
		play.printAnswer(forPrint);
	}
	
	private void printAnswer(ArrayList<Position> forPrint) {
		for(int i =0; i< forPrint.size(); i++){
			System.out.println(i+" 에서 출발하면  "+  forPrint.get(i).getPosX());
		}
	}

	private ArrayList<Position> run(int rowNum){

		ladder.initLadder(rowNum);
		printLadder();
		//출발지 선택은 오프라인에서 자체적으로들 하라고 하고;;
		ArrayList<Position> answer = new ArrayList<Position>();
		
		
		//이 부분을 재귀로 수정할 수 있을 것 같음.0818 
		for(int k=0; k<rowNum; k++){
			Position pos = new Position(k);
			
			for(int i = 0; i < rowNum; i++){
				pos = followLadder(pos);
			}
			answer.add(pos);
			
		}
		return answer;
	}
	
	public Position followLadder(Position pos){
		//포스가 가지고 있는 x, y값을 이용해서, 그 박스 의 colored 값을 확인
		//colored값에 따라서 움직임을 결정한다.  
		
		boolean boxColor= ladder.getLadder().get(pos.getPosX()).getBoxLine().get(pos.getPosY()).isColored();

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
	
	/**
	 * 만들어진 사다리 출력 하는 함수 
	 */
	void printLadder(){
		int n = ladder.getLadder().size();
		
		for(int i = 0; i < n; i++){
			System.out.print(i+"  ");
		}
		System.out.println();
		for(int j = 0; j < n; j++){
			
			for(int i = 0; i< n; i++){
				boolean colored = ladder.getLadder().get(i).getBoxLine().get(j).isColored();
				if(colored){
					System.out.print("|--");
				} else {
					System.out.print("|  ");
				}

//				System.out.print("("+ladder.getLadder().get(i).getBoxLine().get(j).getX()
//				+" "+ladder.getLadder().get(i).getBoxLine().get(j).getY()+
//				" "+ ladder.getLadder().get(i).getBoxLine().get(j).isColored()
//						+")");
			}
			
			System.out.println();
		}
	}
	
}
