import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LandSelectionRound extends Round{

	private int passCount;
	
	public LandSelectionRound(List<Player> players) {
		super(0, players, 0);
		passCount = 0;
	}
	
	public void setUp() {
    	turns = new ArrayList<Turn>();
        for (Player p : players) {
            Turn turn = new LandSelectionTurn(this, p);
            turns.add(turn);
        }
        
        Collections.sort(turns);
        currentTurn = 0;
    }
	
	public void addPass() {
		passCount++;
	}
	
	 /**
     * Causes the round to continue to the next turn.
     */
    public LandSelectionTurn nextTurn() {
	    	LandSelectionTurn current = (LandSelectionTurn) super.nextTurn();
	    	while (current.isPassed()) {
	    		current = (LandSelectionTurn) super.nextTurn();
	    	}
	    	return current;
    }
    
    public boolean hasNextTurn() {
        return passCount != players.size();
    }
}
