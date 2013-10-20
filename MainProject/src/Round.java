import java.util.*;

/**
 * Class that stores the number of turns with the food requirment 
 * and determines turn order for each round. 
 * @author Team 7
 */
public class Round {
    private int foodRequirement;
    private int roundNumber;
    private int currentTurn;
    private List<Player> players;
    private List<Turn> turns;
    
    /**
     * Constructor for the round class.  Stores the round number 
     * along with the players and food requirement
     * @param the round number
     * @param the list of players in the game
     * @param the food requirement for this round
     */
    public Round(int roundNumber, List<Player> players, int foodRequirement) {
        this.roundNumber = roundNumber;
        this.players = players;
        this.foodRequirement = foodRequirement;
        
        turns = new ArrayList<Turn>();
        for (Player p : players) {
            Turn turn = new Turn(this, p);
            turns.add(turn);
        }
        
        Collections.sort(turns);
        currentTurn = 0;
    }
    /**
     * Causes the round to continue to the next turn.
     */
    public void nextTurn() {
    }
    
    public boolean hasNextTurn() {
        return currentTurn < turns.size();
    }
    
    /**
     * Returns the food requirement for the round.  Useful in determining
     * turn length.
     * @return the food requirement for the round
     */
    public int getFoodRequirement() {
        return foodRequirement;
    }
    
}
