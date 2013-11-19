
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;


public class MichaelAddPropertyTest {

	Game g;
	List<Player> players;
	LandSelectionRound currentRound;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		players = new ArrayList<Player>();
		g = new Game();
		Player p1 = new Player();
		Player p2 = new Player();
		p2.setMoney(300);
		Player p3 = new Player();
		p3.setMoney(599);
		Player p4 = new Player();
		p4.setMoney(600);
		Player p5 = new Player();
		p5.setMoney(1200);
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		currentRound = new LandSelectionRound(players, g);
	}
	
	
	
	
	
	
	
	
	/**
	 * Test buy property when the player can buy exactly four properties
	 */
	@Test
	public void buyPropertyTest1(){
		LandSelectionTurn t = (LandSelectionTurn) currentRound.getCurrentTurn();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 1);
		assertEquals("They are equal", t.getPlayer().getMoney(), 1200);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 2);
		assertEquals("They are equal", t.getPlayer().getMoney(), 1200);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 3);
		assertEquals("They are equal", t.getPlayer().getMoney(), 900);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 4);
		assertEquals("They are equal", t.getPlayer().getMoney(), 600);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 5);
		assertEquals("They are equal", t.getPlayer().getMoney(), 300);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 6);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 6);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		t.stop();
	}
	
	/**
	 * Test buy property when the player can buy exactly two properties
	 */
	@Test
	public void buyPropertyTest2(){
		currentRound.nextTurn();
		LandSelectionTurn t = (LandSelectionTurn) currentRound.getCurrentTurn();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 1);
		assertEquals("They are equal", t.getPlayer().getMoney(), 600);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 2);
		assertEquals("They are equal", t.getPlayer().getMoney(), 600);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 3);
		assertEquals("They are equal", t.getPlayer().getMoney(), 300);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 4);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 4);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property with 1 less money needed to buy two properties
	 */
	@Test
	public void buyPropertyTest3(){
		currentRound.nextTurn();
		currentRound.nextTurn();
		LandSelectionTurn t = (LandSelectionTurn) currentRound.getCurrentTurn();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 1);
		assertEquals("They are equal", t.getPlayer().getMoney(), 599);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 2);
		assertEquals("They are equal", t.getPlayer().getMoney(), 599);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 3);
		assertEquals("They are equal", t.getPlayer().getMoney(), 299);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 3);
		assertEquals("They are equal", t.getPlayer().getMoney(), 299);
		currentRound.nextTurn();
	}
	
	
	/**
	 * Test buy property with exactly enough money
	 */
	@Test
	public void buyPropertyTest4(){
		currentRound.nextTurn();
		currentRound.nextTurn();
		currentRound.nextTurn();
		LandSelectionTurn t = (LandSelectionTurn) currentRound.getCurrentTurn();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 1);
		assertEquals("They are equal", t.getPlayer().getMoney(), 300);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 2);
		assertEquals("They are equal", t.getPlayer().getMoney(), 300);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 3);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 3);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property when the player has no money
	 */
	@Test
	public void buyPropertyTest5(){
		currentRound.nextTurn();
		currentRound.nextTurn();
		currentRound.nextTurn();
		currentRound.nextTurn();
		LandSelectionTurn t = (LandSelectionTurn) currentRound.getCurrentTurn();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 1);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 2);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		t.stop();
		t.addProperty(new River(true));
		assertEquals("They are equal", t.getPlayer().getProperty().size(), 2);
		assertEquals("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}

}