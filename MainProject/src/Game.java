import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;



public class Game {
	
	public static final List<String> COLORS = Arrays.asList("Red", "Greed", "Blue", "Yellow", "Orange", "Purple");
	public static final List<String> RACES = Arrays.asList("Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite");

	private List<String> rounds; //TODO: change type to Round
	private GamePanel map;
	private List<Actor> players;
	private String difficulty;
	private String mapType;
	
	private Login window;
	
	public Game() {
		players = new ArrayList<>();
	}
	
	/* Calls the login class */
	public void loginBegin()
	{
		EventQueue.invokeLater(new Runnable(){			
			public void run() {
				try {
					window = new Login(Game.this);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}
	/* Called by Login class when the Login has finished */
	public void loginComplete(JFrame frame){
		difficulty = window.getDifficulty();
		mapType = window.getMapType();
		players = window.getPlayers();
		map.beginDisplay(frame);
		play();
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
	
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.map = new GamePanel();
		game.loginBegin();
		
		
	}
	
}
