import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;


public class MichaelAddPropertyTest {

	Game g;
	List<Player> players;
	Round currentRound;
	
	
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
		Player p6 = null;
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);
		players.add(p6);
		currentRound = new LandSelectionRound(players, g);
	}
	
	/**
	 * Test buy property when the player has no money
	 */
	@Test (expected=NullPointerException.class)
	public void buyPropertyTest1(){
		Turn t = currentRound.getCurrentTurn();
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 1);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 2);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 2);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property with exactly enough money
	 */
	@Test (expected=NullPointerException.class)
	public void buyPropertyTest2(){
		Turn t = currentRound.getCurrentTurn();
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 1);
		assert("They are equal", t.getPlayer().getMoney(), 300);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 2);
		assert("They are equal", t.getPlayer().getMoney(), 300);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 3);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 3);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property with 1 less money needed to buy two properties
	 */
	@Test (expected=NullPointerException.class)
	public void buyPropertyTest3(){
		Turn t = currentRound.getCurrentTurn();
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 1);
		assert("They are equal", t.getPlayer().getMoney(), 599);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 2);
		assert("They are equal", t.getPlayer().getMoney(), 599);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 3);
		assert("They are equal", t.getPlayer().getMoney(), 299);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 3);
		assert("They are equal", t.getPlayer().getMoney(), 299);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property when the player can buy exactly two properties
	 */
	@Test (expected=NullPointerException.class)
	public void buyPropertyTest4(){
		Turn t = currentRound.getCurrentTurn();
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 1);
		assert("They are equal", t.getPlayer().getMoney(), 600);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 2);
		assert("They are equal", t.getPlayer().getMoney(), 600);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 3);
		assert("They are equal", t.getPlayer().getMoney(), 300);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 4);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 4);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property when the player can buy exactly four properties
	 */
	@Test (expected=NullPointerException.class)
	public void buyPropertyTest5(){
		Turn t = currentRound.getCurrentTurn();
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 1);
		assert("They are equal", t.getPlayer().getMoney(), 1200);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 2);
		assert("They are equal", t.getPlayer().getMoney(), 1200);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 3);
		assert("They are equal", t.getPlayer().getMoney(), 900);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 4);
		assert("They are equal", t.getPlayer().getMoney(), 600);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 5);
		assert("They are equal", t.getPlayer().getMoney(), 300);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 6);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		t.addProperty(new River());
		assert("They are equal", t.getPlayer().getProperty().size(), 6);
		assert("They are equal", t.getPlayer().getMoney(), 0);
		currentRound.nextTurn();
	}
	
	/**
	 * Test buy property when the player does not exist
	 */
	@Test (expected=NullPointerException.class)
	public void buyPropertyTest6(){
		Turn t = currentRound.getCurrentTurn();
		t.addProperty(new River());
	}
	

}
