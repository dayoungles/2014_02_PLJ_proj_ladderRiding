package ladderline;

import junit.framework.TestCase;

public class BoxTest extends TestCase {
	public void testIsColored() throws Exception {
		Box box = new Box(1,3);
		box.setColored(true);
		assertEquals(true, box.isColored());
	}
	
	public void testGetX() throws Exception {
		Box box = new Box(1, 3);
		assertEquals(1, box.getX());
	}
	
	public void testSetY() throws Exception {
		Box box = new Box(1, 3);
		box.setY(5);
		assertEquals(5, box.getY());
		
	}
}
