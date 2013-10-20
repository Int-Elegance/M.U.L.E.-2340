/**
 * 
 * @author Team 7
 * Represent a player in the MULE game
 *
 */
public class Player extends Actor implements Comparable {
	
	private Race race;
	private String color;
	private String name;
	private int score;
	private int money;

	private int food;

	public Player() {}
	
	/**
	 * @return the player's score
	 */
	public int getScore()
	{
		return score;
	}
	

	public int getFood() {
	    return food;
	}
	
	public void setFood(int food) {
	    this.food = food;
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
	
	public int compareTo(Object o) {
	    return this.getScore() - ((Player)o).getScore();
	}
	
}
