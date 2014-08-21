package ladderline;

import junit.framework.TestCase;
import ladderline.Play;
import ladderline.Position;

public class PlayTest extends TestCase {
	
	public void testMeetSelfColored() throws Exception {
		Play play = new Play();
		int n = 3;
		play.ladder.initLadder(n);
		for(int j = 0; j < n; j++){
			for(int i = 0; i< n; i++){
				System.out.print("("+play.ladder.getLadder().get(i).getBoxLine().get(j).getX()
				+" "+play.ladder.getLadder().get(i).getBoxLine().get(j).getY()+
				" "+ play.ladder.getLadder().get(i).getBoxLine().get(j).isColored()
						+")");
			}
			System.out.println();
		}
		 Position pos = play.followLadder(new Position(1));
		 System.out.println(pos.toString());
		
	}
	
	public void testFollowLadder() throws Exception {
		Position pos = new Position(1);
		Play play = new Play();
		play.ladder.initLadder(4);
		
		
	}
	
}
