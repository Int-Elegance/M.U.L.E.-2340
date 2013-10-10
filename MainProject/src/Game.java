/**
 * @author Team 7
 * Essentially represents the runner for the MULE game
 */
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
		players = new ArrayList<Actor>();
	}
	
	/**
	 * Calls the login class
	 */
	public void loginBegin() {
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
	
	/**
	 *  Called by Login class when the Login has finished
	 * @param frame Represents the frame on which to display the visuals
	 */
	public void loginComplete(JFrame frame){
		difficulty = window.getDifficulty();
		mapType = window.getMapType();
		players = window.getPlayers();
		map.beginDisplay(frame);
		play();
	}
	
	//TODO: Implement
	public boolean play() { return false; }
	
	/**
	 * Adds a player to the game
	 * Between 2 and 4 players may play at once 
	 * @param p The player to add to the game
	 */
	public void addPlayer(Player p){
		players.add(p);
	}
	
	/**
	 * @return The list of players currently added to the game
	 */
	public List<Actor> getPlayers() {
		return players;
	}
	
	
	/**
	 * Runs the game
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.map = new GamePanel();
		game.loginBegin();
	}
}
