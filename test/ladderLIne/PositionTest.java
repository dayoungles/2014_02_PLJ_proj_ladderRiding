package ladderline;

import junit.framework.TestCase;
import ladderline.Position;

public class PositionTest extends TestCase {
	
	public void testGetposx() throws Exception {
		Position pos = new Position(1, 2);
		assertEquals(1, pos.getPosX());
	}
	
	public void testGetposy() throws Exception {
		Position pos = new Position(1, 2);
		assertEquals(2,pos.getPosY());
	}
	
	public void testSetposy() throws Exception {
		Position pos = new Position();
		pos.setPosXY(7, 3);
		
		assertEquals(3, pos.getPosY());
	}
	//junit 왜 이렇게 느리지;;;
}
