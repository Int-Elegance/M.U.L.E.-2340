import java.util.List;
import java.util.ArrayList;



public class Game {

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
