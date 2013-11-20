import static org.junit.Assert.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;
import org.junit.runner.RunWith;
import org.junit.*;

import java.util.*;

@RunWith(Parameterized.class)
public class PlayerTest {
    private Player player;
    private Player copy;
    
    @Before
    public void initialize() {
        Race r = player.getRace();
        String color = player.getColor();
        player = new Player();
        player.setColor(color);
        player.setRace(r);
        player.setImage();
    }
    
    public PlayerTest(Player p) {
        this.player = p;
    }
    
    @Parameterized.Parameters
    public static Collection players() {
        Player p1 = new Player();
        p1.setRace(Race.Human);
        p1.setColor("Red");
        p1.setImage();
        
        Player p2 = new Player();
        p2.setRace(Race.Flapper);
        p2.setColor("Blue");
        p2.setImage();
        
        Player p3 = new Player();
        p3.setRace(Race.Bonzoid);
        p3.setColor("Orange");
        p3.setImage();
        
        Player p4 = new Player();
        p4.setRace(Race.Ugaite);
        p4.setColor("Yellow");
        p4.setImage();
        
        return Arrays.asList(new Object[][] {
            {p1},
            {p1},
            {p3},
            {p4}
        });
    }
    
    @Test
    public void testStartingMoney() {
        int expectedStart = player.getRace().getStartingMoney();
        assertEquals(expectedStart, player.getMoney());
    }
    
    @Test
    public void testImage() {
        assertNotNull(player.getImage());
    }
    
    @Test
    public void testPurchase() {
        assertFalse(player.canPurchase(Integer.MAX_VALUE));
    }
    
    @Test
    public void testChange() {
        player.changeMoney(Integer.MIN_VALUE);
        assertEquals(player.getMoney(), 0);
    }
    
    @Test
    public void testMule() {
        assertFalse(player.hasMule());
    }
    
    @Test
    public void testSetMule() {
        Mule mule = new Mule(player, Mule.BASIC);
        player.setMule(mule);
        assertTrue(player.hasMule());
        assertNotNull(player.getMule());
    }
    
    @Test
    public void testCompare() {
        Player stacked = new Player();
        stacked.setMoney(Integer.MAX_VALUE);
        assertTrue(player.compareTo(stacked) < 0);
        Player poor = new Player();
        assertTrue(player.compareTo(poor) > 0);
    }
}
