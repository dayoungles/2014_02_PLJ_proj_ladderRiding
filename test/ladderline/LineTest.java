package ladderline;

import java.util.ArrayList;

import junit.framework.TestCase;
import ladderline.Line;

public class LineTest extends TestCase {
	public void testInitLine() throws Exception {
		Line line = new Line();
		line.initLine(1, 5);
		//라인의 박스가 모두 false로 잘 들어갔는지 확인. 
//		assertEquals(false, line.getBoxLine().get(4).isColored());
		//assertEquals(false, line.getBoxLine().get(5).isColored());
		for(int i =0; i< 5; i ++){
			System.out.println(line.getBoxLine().get(i).isColored());
		}
	}
	
	public void testColoringLine() throws Exception{
		Line line = new Line();
		line.initLine(1, 5);
//		line.coloringLine();
		//헐 랜덤값은 어떻게 테스트를 하지?;;;;
		for(int i =0; i< 5; i ++){
			System.out.println(line.getBoxLine().get(i).isColored());
		}
	}
}
