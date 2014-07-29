package ladderline;

import java.util.ArrayList;

import junit.framework.TestCase;

public class LadderTest extends TestCase {
	public void testGetLadder() throws Exception {
		Ladder ladder = new Ladder();
		ArrayList<Line> lineladder = new ArrayList<Line>();
		assertEquals(lineladder, ladder.getLadder());
		
	}
	
	public void testMakeLadder() throws Exception {
		Ladder ladder = new Ladder();
		ladder.makeLadder(5);
		for(int i = 0; i < 5; i++){
			for(int j = 0; j< 5; j++){
				System.out.println("("+ladder.getLadder().get(i).getBoxLine().get(j).getX()
				+" "+ladder.getLadder().get(i).getBoxLine().get(j).getY()+
				" "+ ladder.getLadder().get(i).getBoxLine().get(j).isColored()
						+")");
			}
			System.out.println("------------------------");
		}
	}

}
