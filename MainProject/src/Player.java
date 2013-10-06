import java.util.List;

public class Player extends Actor {
	
	int race;
	String name;
	String color;
	int score = 0;
	int money = 0;
	int food = 0;
	int energy = 0;
	int ore = 0;
	List<String> mules; //TODO: change type to MULE
	
	public Player(String image, String tile, int race, String name, String color)
	{
		super(image, tile);
		this.race = race;
		this.name = name;
		this.color = color;
		
		//TODO: calculate the player's money
	}

}
