/**
 * 
 * @author Team 7
 * Represent a player in the MULE game
 *
 */
public class Player extends Actor {
	
	private int race; //TODO: change type of race to enum
	private String color;
	private String name;
	
	public Player() {}
	
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
	public int getRace() {
		return race;
	}
	
	/**
	 * @param race The player's race
	 */
	public void setRace(int race) {
		this.race = race;
	}
	
	/**
	 * @return The color of the player
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @param color The color of the player
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
