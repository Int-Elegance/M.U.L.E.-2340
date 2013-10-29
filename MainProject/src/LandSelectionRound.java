import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Team 7
 * A round during the land selection phase of the game
 */
public class LandSelectionRound extends Round{

	private int passCount;
	
	/**
	 * Constructor for the LandSelectionRound class
	 * 
	 * passCount is the number of players who have passed or can't spend anymore money
	 * 
	 * @param players players of the game
	 */
	public LandSelectionRound(List<Player> players, Game game) {
		super(0, players, 0, 0,game);
		passCount = 0;
	}
	
	/**
	 * Sets up Round by creating a LandSelectionTurn 
	 * for each player.
	 * Called in the superclass constructor
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void setUp() {
    	turns = new ArrayList<Turn>();
    	/*
        Collections.sort(players);
        Collections.reverse(players);
        */
        for (Player p : players) {
            Turn turn = new LandSelectionTurn(this, p);
            turns.add(turn);
        }
        
        Collections.sort(turns);
        Collections.reverse(turns);
        currentTurn = 0;
    }
	
	/**
	 * Indicates that someone has passed or run out of money
	 * 
	 */
	public void addPass() {
		passCount++;
	}
	
	 /**
     * Causes the round to continue to the next turn.
     * 
     * @return the next turn
     */
    public LandSelectionTurn nextTurn() {
	    	LandSelectionTurn current = (LandSelectionTurn) super.nextTurn();
	    	while (current.isPassed()) {
	    		current = (LandSelectionTurn) super.nextTurn();
	    	}
	    	return current;
    }
    
    /**
     * @return true if another Turn is available
     */
    public boolean hasNextTurn() {
        return passCount != players.size();
    }
}
