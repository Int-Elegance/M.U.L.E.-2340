
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import org.junit.Before;
import org.junit.Test;


public class JacobPlayerSetImageTest {
	
	Player p;
	
	
	@Before 
	public void init(){
		Player p = new Player();		
	}
	
	/**
	 * Test setImage when:
	 * 		- race = human
	 * 		- color = red
	 */
	@Test
	public void setImage1(){
		p.setRace(Game.RACES[0]);
		p.setColor("Red");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/humanRed.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = human
	 * 		- color = orange
	 */
	@Test
	public void setImage2(){
		p.setRace(Game.RACES[0]);
		p.setColor("Orange");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/humanOrange.png"));
		assertEquals("Equals", image, p.getImage());
		
	}
	
	/**
	 * Test setImage when:
	 * 		- race = human
	 * 		- color = yellow
	 */
	@Test
	public void setImage3(){
		p.setRace(Game.RACES[0]);
		p.setColor("Yellow");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/humanYellow.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = human
	 * 		- color = blue
	 */
	@Test
	public void setImage4(){
		p.setRace(Game.RACES[0]);
		p.setColor("Blue");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/humanBlue.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = flapper
	 * 		- color = red
	 */
	@Test
	public void setImage5(){
		p.setRace(Game.RACES[1]);
		p.setColor("Red");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/flapperRed.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = flapper
	 * 		- color = orange
	 */
	@Test
	public void setImage6(){
		p.setRace(Game.RACES[1]);
		p.setColor("Orange");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/flapperOrange.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = flapper
	 * 		- color = yellow
	 */
	@Test
	public void setImage7(){
		p.setRace(Game.RACES[1]);
		p.setColor("Yellow");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/flapperYellow.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = flapper
	 * 		- color = blue
	 */
	@Test
	public void setImage8(){
		p.setRace(Game.RACES[1]);
		p.setColor("Blue");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/flapperBlue.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = bonzoid
	 * 		- color = red
	 */
	@Test
	public void setImage9(){
		p.setRace(Game.RACES[2]);
		p.setColor("Red");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/bonzoidRed.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = bonzoid
	 * 		- color = orange
	 */
	@Test
	public void setImage10(){
		p.setRace(Game.RACES[2]);
		p.setColor("Orange");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/bonzoidOrange.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = bonzoid
	 * 		- color = yellow
	 */
	@Test
	public void setImage11(){
		p.setRace(Game.RACES[2]);
		p.setColor("Yellow");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/bonzoidYellow.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = bonzoid
	 * 		- color = blue
	 */
	@Test
	public void setImage12(){
		p.setRace(Game.RACES[2]);
		p.setColor("Blue");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/bonzoidBlue.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = ugaite
	 * 		- color = red
	 */
	@Test
	public void setImage13(){
		p.setRace(Game.RACES[3]);
		p.setColor("Red");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/ugaiteRed.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = ugaite
	 * 		- color = orange
	 */
	@Test
	public void setImage14(){
		p.setRace(Game.RACES[3]);
		p.setColor("Orange");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/ugaiteOrange.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = ugaite
	 * 		- color = yellow
	 */
	@Test
	public void setImage15(){
		p.setRace(Game.RACES[3]);
		p.setColor("Yellow");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/ugaiteYellow.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = ugaite
	 * 		- color = blue
	 */
	@Test
	public void setImage16(){
		p.setRace(Game.RACES[3]);
		p.setColor("Blue");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/ugaiteBlue.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = buzzite
	 * 		- color = red
	 */
	@Test
	public void setImage17(){
		p.setRace(Game.RACES[4]);
		p.setColor("Red");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/buzziteRed.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = buzzite
	 * 		- color = orange
	 */
	@Test
	public void setImage18(){
		p.setRace(Game.RACES[4]);
		p.setColor("Orange");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/buzziteOrange.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = buzzite
	 * 		- color = yellow
	 */
	@Test
	public void setImage19(){
		p.setRace(Game.RACES[4]);
		p.setColor("Yellow");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/buzziteYellow.png"));
		assertEquals("Equals", image, p.getImage());
	}
	
	/**
	 * Test setImage when:
	 * 		- race = buzzite
	 * 		- color = blue
	 */
	@Test
	public void setImage20(){
		p.setRace(Game.RACES[4]);
		p.setColor("Blue");
		p.setImage();
		ImageIcon image = new ImageIcon(getClass().getResource("resources/buzziteBlue.png"));
		assertEquals("Equals", image, p.getImage());
	}
}