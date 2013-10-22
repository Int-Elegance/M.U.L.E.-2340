import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;
import java.awt.event.ActionEvent;

/**
 * @author Team 7
 * Class to represent a turn in the land selection phase of the game
 */
public class LandSelectionTurn extends Turn {
	
	private int numTurns;
	private boolean passed;
	
	private static final int TIME = 60;

	
	/**
	 * Constructor for LandSelectionTurn
	 * 
	 * passed indicates that the turn has not been passed
	 * 
	 * @param LandSelectionRound current Land Selection Round
	 * @param player player corresponding to the turn
	 */
	public LandSelectionTurn(LandSelectionRound round, Player player) {
		super(round, player);
		secondsLeft = TIME;
		passed = false;
	}
	
	
	/**
	 * gets the time of each LandSelectionTurn
	 * 
	 * @return time of turn
	 */
	public int getTime() {
		return TIME;
	}
	
	/**
	 * add the property to the player if he has enough money
	 * 
	 * @param p Property to be added to the player whos turn it is
	 */
	public void addProperty(Property p) {
		if (numTurns > 1){
			if (player.getMoney() >= 300) {
				player.addProperty(p);
				player.changeMoney(-300);
				if (player.getMoney() < 300) {
					passed = true;
					((LandSelectionRound) round).addPass();
				}
			} 
		} else {
			player.addProperty(p);
		}
	}
	
	 /**
     * Stops the time on the turn
     */
    public void stop() {
        timer.stop();
        secondsLeft = getTime();
        numTurns++;
    }

    
    /**
     * Indicates the turn has been passed
     */
	public void pass() {
		((LandSelectionRound) round).addPass();
		passed = true;
	}
	
	/**
	 * true if the turn is passed
	 * 
     * @return if the turn has been passed
     */
	public boolean isPassed() {
		return passed;
	}
}
