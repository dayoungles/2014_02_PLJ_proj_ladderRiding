package ladderline;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import junit.framework.TestCase;

public class LadderTest extends TestCase {
	public void testGetLadder() throws Exception {
		Ladder ladder = new Ladder();
		ArrayList<Line> lineladder = new ArrayList<Line>();
		assertEquals(lineladder, ladder.getLadder());
		
	}
	
	public void testMakeLadder() throws Exception {
		Ladder ladder = new Ladder();
		ladder.initLadder(5);
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
	
	public void testRandom() throws Exception {
		for(int i = 0 ; i< 100; i++){
			int range = (int)(Math.random()*10);
			System.out.println(range);
		}
	}
	
	public void testColoringLadder() throws Exception {
		Ladder ladder = new Ladder();
		ladder.initLadder(5);
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
	
	public void testNewColoringLogic() throws Exception {
		Ladder ladder = new Ladder();
		ladder.initLadder(5);
		
	}
	
	public void testrandomNumn() throws Exception {
		Random random = new Random();
		int x= random.nextInt(15);
		System.out.println(x);

	}

}
