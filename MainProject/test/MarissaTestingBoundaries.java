import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class MarissaTestingBoundaries {
	private TownView ctt;
	
	@Before 
	public void init(){
		ctt= new TownView(new Turn(new Round(0, null, 0, 0, null), new Player()));
		
	}
	/*
	 * Tests if player is touching the bottom edge
	 */
    @Test
    public void playerOnBottomEdge() {
    	ctt.movePlayer(250, 399);
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the right edge
	 */
    @Test
    public void playerOnRightEdge() {
    	ctt.movePlayer(399, 250);
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the left edge
	 */
    @Test
    public void playerOnLeftEdge() {
    	ctt.movePlayer(200-ctt.getPlayerWidth()+1,250 );
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the top edge
	 */
    @Test
    public void playerOnTopEdge() {
    	ctt.movePlayer(250,200-ctt.getPlayerHeight()+1);
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }

	/*
	 * Tests if player is not touching the bottom edge
	 */
    @Test
    public void playerOffBottomEdge() {
    	ctt.movePlayer(250, 400);
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is not touching the right edge
	 */
    @Test
    public void playerOffRightEdge() {
    	ctt.movePlayer(400, 250);
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is not touching the left edge
	 */
    @Test
    public void playerOffLeftEdge() {
    	ctt.movePlayer(200-ctt.getPlayerWidth(),250 );
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }

	/*
	 * Tests if player is not touching the top edge
	 */
    @Test
    public void playerOffTopEdge() {
    	ctt.movePlayer(250,200-ctt.getPlayerHeight());
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the top left corner
	 */
    @Test
    public void playerOnTopLeftCorner() {
    	ctt.movePlayer(200-ctt.getPlayerWidth()+1, 200-ctt.getPlayerHeight()+1);
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the top right corner
	 */
    @Test
    public void playerOnTopRightCorner() {
    	ctt.movePlayer(399, 399);
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the bottom left corner
	 */
    @Test
    public void playerOnBottomLeftCorner() {
    	ctt.movePlayer(200-ctt.getPlayerWidth()+1,399 );
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is touching the bottom right corner
	 */
    @Test
    public void playerOnBottomRightCorner() {
    	ctt.movePlayer(399,200-ctt.getPlayerHeight()+1);
	    assertEquals(true, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is not touching the top left corner
	 */
    @Test
    public void playerOffTopLeftCorner() {
    	ctt.movePlayer(200-ctt.getPlayerWidth(), 200-ctt.getPlayerHeight());
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is not touching the top right corner
	 */
    @Test
    public void playerOffTopRightCorner() {
    	ctt.movePlayer(400, 400);
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is not touching the bottom left corner
	 */
    @Test
    public void playerOffBottomLeftCorner() {
    	ctt.movePlayer(200-ctt.getPlayerWidth(),400);
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    }
	/*
	 * Tests if player is not touching the bottom right corner
	 */
    @Test
    public void playerOffBottomRightCorner() {
    	ctt.movePlayer(400,200-ctt.getPlayerHeight());
	    assertEquals(false, ctt.checkForSpecificLocation(200,200,200,200));
    } 
}
