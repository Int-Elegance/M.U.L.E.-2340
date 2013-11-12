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
	    	return Color.ORANGE;
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
	
}
