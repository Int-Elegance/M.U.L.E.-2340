import java.util.List;

public class Player extends Actor {
	
	private int race;
	private String name;
	private String color;
	private int score = 0;
	private int money = 0;
	private int food = 0;
	private int energy = 0;
	private int ore = 0;
	private List<String> mules; //TODO: change type to MULE
	
	public Player(String image, String tile, int race, String name, String color)
	{
		super(image, tile);
		this.race = race;
		this.name = name;
		this.color = color;
		
		//TODO: calculate the player's money
	}

	public int getRace() {
		return race;
	}

	public void setRace(int race) {
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	//TODO make sure it works with Mule class
	public List<String> getMules() {
		return mules;
	}
	
	//TODO make sure it works with Mule class
	public void addMule(String mule) {
		mules.add(mule);
	}

}
