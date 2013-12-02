import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * @author Team 7
 * Represent a player in the MULE game
 *
 */
public class Player extends Actor implements Comparable<Player>, Serializable {
	
	private static final long serialVersionUID = 11L;
	public static final int NORTH_OFFSET = 0; // offset to access north-facing frames in images array
	public static final int EAST_OFFSET = 4; // offset to access east-facing frames in images array
	public static final int SOUTH_OFFSET = 8; // offset to access south-facing frames in images array
	public static final int WEST_OFFSET = 12; // offset to access west-facing frames in images array
	private Race race;
	private String color;
	private String name;
	private int score;
	private int money;
	private int smithore;
	private int energy;
	private List<Property> properties;
	private int food;
	private ImageIcon image; // later, make this an array to hold all animation frames
	private ImageIcon[] images;
	private Mule mule;

	/**
	 * Player constructor
	 * 
	 * initializes property list
	 */
	public Player() {
		properties = new ArrayList<Property>();
		this.food = 8;
		this.energy = 4;
		this.smithore = 0;
		this.mule = null;
	}
	
	public String toString()
	{
		return name;
	}
	/**
	 * Returns the current mule in player's inventory
	 * @return player's mule
	 */
	 public boolean hasMule() {
	return mule != null;
	 }
	 
	 /**
	  * Sets the mule currently with the player
	  * @param the mule that is currently with the player
	  */
	 public void setMule(Mule mule) {
	    this.mule = mule;
	 }
	 
	 /**
	  * Returns the mule currently in the player's inventory
	  * @return the mule currently in the player's inventory
	  */
	 public Mule getMule() {
	    return mule;
	 }
	
	/**
	 * @return the player's score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * @return the player's food
	 */
	public int getFood() {
	    return food;
	}
	
	/**
	 * @param the players new food level
	 */
	public void setFood(int food) {
	    this.food = food;
	}
	

	/**
	 * @param p the property to be added to the players owned property
	 */
	public void addProperty(Property p)
	{
		properties.add(p);
		p.setOwned(true);
		p.setOwner(this);
	}
	
	
	/**
	 * @param score The player's score to be changed to
	 */
	public void setScore(int score)
	{
		this.score = score;
	}
	
	/**
	 * @return the player's money
	 */
	public int getMoney()
	{
		return money;
	}
	
	/**
	 * @param score The player's money to be changed to
	 */
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	/**
	 * This method returns true if the player has enough money to purchase an item from the store
	 * @param cost the cost of the item
	 */
	public boolean canPurchase(int cost) {
	    return money - cost >= 0;
	}
	
	/**
	 * @param amount how much you want to change the money be
	 */
	public void changeMoney(int amount) {
		this.money = money + amount;
		if(money<0){
			this.money=0;
		}
	}
	
	/**
	 * Changes the player's energy
	 * @param energy the value the one wants to set energy to
	 */
	public void setEnergy(int energy) {
        this.energy = energy;	
    }
    
    /**
     * Returns the value of the player's energy
     * @return the value of the player's energy
     */
    public int getEnergy() {
        return energy;
    }
	
	/**
	 * Changes the player's energy
	 * @param energy the value the one wants to set energy to
	 */
	public void setSmithore(int smithore) {
        this.smithore = smithore;	
    }
    
    /**
     * Returns the value of the player's energy
     * @return the value of the player's energy
     */
    public int getSmithore() {
        return smithore;
    }
	
	/**
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name The name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the player's race
	 */
	public Race getRace() {
		return race;
	}
	
	/**
	 * @param race The player's race
	 */
	public void setRace(Race race) {
		this.money = race.getStartingMoney();
		this.race = race;
	}
	
	/**
	 * Precondition: (race != null) && (color != null)
	 * Postcondition: 
	 * sets the player's image icon based on race and color
	 */
	public void setImage() {
		ImageIcon playerIcon = new ImageIcon(getClass().getResource("resources/" + race.toString().toLowerCase() + color + ".png"));
		this.image = playerIcon;
	}
	
	/**
	 * Sets player's animation frames accordingly
	 */
	public void setImages() {
		ImageIcon[] playerIcons = new ImageIcon[16];
		
		// set north-facing frames
		for (int i=0; i<4; i++)
		{
			playerIcons[i+NORTH_OFFSET] = new ImageIcon(getClass().getResource("resources/" + race.toString().toLowerCase() + color.toString() + "_n" + i + ".png"));			
		}
		// set east-facing frames
		for (int i=0; i<4; i++)
		{
			playerIcons[i+EAST_OFFSET] = new ImageIcon(getClass().getResource("resources/" + race.toString().toLowerCase() + color.toString() + "_e" + i + ".png"));			
		}
		// set south-facing frames
		for (int i=0; i<4; i++)
		{
			playerIcons[i+SOUTH_OFFSET] = new ImageIcon(getClass().getResource("resources/" + race.toString().toLowerCase() + color.toString() + "_s" + i + ".png"));			
		}
		// set west-facing frames
		for (int i=0; i<4; i++)
		{
			playerIcons[i+WEST_OFFSET] = new ImageIcon(getClass().getResource("resources/" + race.toString().toLowerCase() + color.toString() + "_w" + i + ".png"));			
		}
		
		
		this.images = playerIcons;
	}
	
	/**
	 * @return The color of the player
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @return the color of the player
	 */
	public Color getColorRepresentation() {
	    if (color.equals("Red"))
	        return Color.RED;
	    else if (color.equals("Orange"))
	    	return new Color(255,69,0);//Color.ORANGE;
	    else if (color.equals("Blue"))
	        return Color.BLUE;
	    else
	    	return Color.YELLOW;
	}
	
	/**
	 * @return the image icon that represents the player
	 */
	public ImageIcon getImage() {
		return image;
	}
	
	/**
	 * @return an array containing all of the player's animation frames
	 */
	public ImageIcon[] getImages()
	{
		return images;
	}
	
	/**
	 * @return an array containing only the north-facing frames
	 */
	public ImageIcon[] getNFrames()
	{
		ImageIcon[] frames = new ImageIcon[4];
		for (int i=0; i<4; i++)
		{
			frames[i] = images[NORTH_OFFSET+i];
		}
		return frames;
	}
	
	/**
	 * @return an array containing only the east-facing frames
	 */
	public ImageIcon[] getEFrames()
	{
		ImageIcon[] frames = new ImageIcon[4];
		for (int i=0; i<4; i++)
		{
			frames[i] = images[EAST_OFFSET+i];
		}
		return frames;
	}
	
	/**
	 * @return an array containing only the south-facing frames
	 */
	public ImageIcon[] getSFrames()
	{
		ImageIcon[] frames = new ImageIcon[4];
		for (int i=0; i<4; i++)
		{
			frames[i] = images[SOUTH_OFFSET+i];
		}
		return frames;
	}
	
	/**
	 * @return an array containing only the west-facing frames
	 */
	public ImageIcon[] getWFrames()
	{
		ImageIcon[] frames = new ImageIcon[4];
		for (int i=0; i<4; i++)
		{
			frames[i] = images[WEST_OFFSET+i];
		}
		return frames;
	}
	
	/**
	 * @param color The color of the player
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Compares two players
	 * 
	 * @param o object to be compared to
	 * @return int number representing relationship
	 */
	public int compareTo(Player o) {
	    return this.getMoney() - o.getMoney();
	}
	
	/**
	 * @return the list of property that the player owns
	 */
	public List<Property> getProperty() {
		return properties;
	}
}
