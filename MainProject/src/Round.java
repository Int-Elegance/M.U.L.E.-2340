import java.util.*;

/**
 * Class that stores the number of turns with the food requirment 
 * and determines turn order for each round. 
 * @author Team 7
 */
public class Round {
    private int foodRequirement;
    private int nextFoodRequirement;
    private int roundNumber;
    protected int currentTurn;
    protected List<Player> players;
    protected List<Turn> turns;
    protected NotificationPanel notificationPanel;
    
    /**
     * Constructor for the round class.  Stores the round number 
     * along with the players and food requirement
     * @param the round number
     * @param the list of players in the game
     * @param the food requirement for this round
     */
    public Round(int roundNumber, List<Player> players, int foodRequirement, int nextFoodRequirement) {

        this.roundNumber = roundNumber;
        this.nextFoodRequirement = nextFoodRequirement;
        this.players = players;
        this.foodRequirement = foodRequirement;
        setUp();
    }
    
    /**
     * Sets up by creating a turn for each player
     */
    @SuppressWarnings("unchecked")
	public void setUp() {
    	turns = new ArrayList<Turn>();
        for (Player p : players) {
            Turn turn = new Turn(this, p);
            turns.add(turn);
        }
        
        Collections.sort(turns);
        Collections.reverse(turns);
        currentTurn = 0;
    }
    
    /**
     * sets the notification panel of the round
     * 
     * @param notificationPanel the notification panel for the game
     */
    public void setNotificationPanel(NotificationPanel notificationPanel){
    	this.notificationPanel=notificationPanel;
    }
    
    /**
     * @return the number of turns
     */
    public int getTurns() {
    	return turns.size();
    }
    
    /**
     * Causes the round to continue to the next turn.
     */
    public Turn nextTurn() {
    	currentTurn = (currentTurn + 1) % turns.size();
    	return turns.get(currentTurn);
    }
    
    /**
     * @return true if another turn exists in round
     */
    public boolean hasNextTurn() {
        return currentTurn + 1 < turns.size();
    }
    
    /**
     * @return the current turn
     */
    public Turn getCurrentTurn() {
    	return turns.get(currentTurn);
    }
    
    /**
     * Returns the food requirement for the round.  Useful in determining
     * turn length.
     * @return the food requirement for the round
     */
    public int getFoodRequirement() {
        return foodRequirement;
    }
    
    /**
     * Updates the panel
     */
    public void panelUpdate(){
    	if(notificationPanel!=null){
    		notificationPanel.update();
    	}
    }
    
    /**
     * @return the round number
     */
   public int getRoundNumber() {
	   return roundNumber;
   }
   
   /**
    * @return the next food requirement
    */
   public int getNextFoodRequirement()
   {
	   return nextFoodRequirement;
   }
   
   
}
