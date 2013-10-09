import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class Game {
	
	public static final List<String> COLORS = Arrays.asList("Red", "Greed", "Blue", "Yellow", "Orange", "Purple");
	public static final List<String> RACES = Arrays.asList("Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite");

	List<String> rounds; //TODO: change type to Round
	//GamePanel map;
	List<Actor> players;
	
	public Game() {
		players = new ArrayList<>();
	}
	
	public boolean login()
	{
		//TODO: implement
		return false;
	}
	
	public boolean initializer()
	{
		//TODO: implement
		return false;
	}
	
	public boolean play()
	{
		//TODO: implement
		return false;
	}
	
	public void addPlayer(Player p){
		players.add(p);
	}
	
	public List<Actor> getPlayers() {
		return players;
	}
}
