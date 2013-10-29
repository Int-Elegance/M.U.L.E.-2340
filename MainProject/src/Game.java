import java.awt.EventQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author Team 7
 * Essentially represents the runner for the MULE game
 */
public class Game {
	
	public static final List<String> COLORS = Arrays.asList("Red", "Orange", "Blue", "Yellow");
	public static final Race[] RACES = Race.values();
	private List<Round> rounds; 
	private GamePanel map;
	private GamePanel gamePanel;
	private NotificationPanel notificationPanel;
	private List<Player> players;
	private Round currentRound;
	private String difficulty;
	private String mapType;
	private Login window;
	private JFrame frame;
	public static final char[][] STANDARD_MAP = {{'P', 'P', '1', 'P', 'R', 'P', '3', 'P', 'P'},
	                                             {'P', '1', 'P', 'P', 'R', 'P', 'P', 'P', '3'},
	                                             {'3', 'P', 'P', 'P', 'T', 'P', 'P', 'P', '1'},
	                                             {'P', '2', 'P', 'P', 'R', 'P', '2', 'P', 'P'},
                                                 {'P', 'P', '2', 'P', 'R', 'P', 'P', 'P', '2'}};
	
	
	/**
	 * Constructor for the game class
	 */
	public Game() {
		players = new ArrayList<Player>();
		gamePanel = new GamePanel(mapParser(STANDARD_MAP), this);
	}
	
	//TODO figure out a better way to have components visible everywhere to repaint
	/**
	 * This method sets the notification panel for the game.
	 * @param notification panel to set
	 */
	public void setNotificationPanel(NotificationPanel p) {
		notificationPanel = p;
	}
	
	/**
	 * returns the notification panel used in the Game class
	 * @return the notification panel being used
	 */
	public NotificationPanel getNotificationPanel() {
		return notificationPanel;
	}
	
	/**
	 * Calls the login class and initialized the login sequence
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
		this.frame=frame;
		play();
	}
	
	/**
	 * Starts the land selection phase
	 */
	private void landSelectionBegin() {
		getCurrentTurn().start();
	}	
	
	//TODO: Implement
	/**
	 * Initializes the land selection round and shows the gamepanel, notification panel
	 */
	public boolean play() { 
		LandSelectionRound round = new LandSelectionRound(players, this);
		currentRound = round;
		gamePanel.beginDisplay(frame);
		round.setNotificationPanel(notificationPanel);
		landSelectionBegin();
		return false; 
		
	}
	
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
	public List<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Returns the current round.
	 * @return Current round of the game
	 */
	public Round getCurrentRound() {
		return currentRound;
	}
	
	/**
	 * Returns the current round.
	 * @return Current turn of the game
	 */
	public Turn getCurrentTurn() {
		return currentRound.getCurrentTurn();
	}
	
	//TODO implement
	/**
	 * Returns the round that should be next in the game sequence
	 * @return the next round
	 */
	public Round nextRound() {
		currentRound = new Round(0, players, 0, 0, this);
		return currentRound;
	}
	
	
	/**
	 * Main method for the Game class that creates an Game
	 * object and initializes the login sequence.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.loginBegin();
	}
	
	/**
	 * Private method that parses 2D char array into a 2D tile array.
	 * @param 2D char array representing map. 'T' represents town, 'P' represents plain, '1' is mountain one, '2' is mountain 2, and '3' is mountain three.
	 * @return tile representation of the char array
	 */
	private static Tile[][] mapParser(char[][] map) {
	    Tile[][] parsedMap = new Tile[map.length][map[0].length];
	    for (int i = 0; i < map.length; i++) {
	        for (int j = 0; j < map[i].length; j++) {
	            if (map[i][j] == 'R')
	                parsedMap[i][j] = new River();
	            else if (map[i][j] == 'P')
	                parsedMap[i][j] = new Plain();
	            else if (map[i][j] == '1')
	                parsedMap[i][j] = new Mountain(Mountain.TYPE_1);
	            else if (map[i][j] == '2')
	                parsedMap[i][j] = new Mountain(Mountain.TYPE_2);
	            else if (map[i][j] == '3')
	                parsedMap[i][j] = new Mountain(Mountain.TYPE_3);
	            else if (map[i][j] == 'T')
	                parsedMap[i][j] = new Town();

	        }
	    }
	    return parsedMap;
	}
    
    /**
     * Causes the game to go to the next turn
     */
	public void nextTurn() {
		getCurrentTurn().stop();
		if (getCurrentRound().hasNextTurn()) {
			getCurrentRound().nextTurn();
			getCurrentTurn().start();
			
		} else {
			nextRound();
			TownView town = new TownView(getCurrentTurn().getPlayer());  
	        town.displayTownSquare();
		}
		
	}
}
