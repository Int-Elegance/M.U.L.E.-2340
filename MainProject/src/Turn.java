import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This class takes care of the turn for a player and keeps track of the time passing.
 * @author Team 7
 */
public class Turn implements Comparable {
    
    protected Timer timer;
    protected int secondsLeft;
    protected Round round; 
    protected Player player;
    
    
    /**  
     * Constructor for the Turn class, it creates a new turn with a timer.
     * Determines the number of seconds by the food requirement and the player's food
     * 
     * @param This is the round that the turn is contained within. 
     * @param This is the player who's turn it is
     */
    public Turn(final Round round, Player player) {
        this.round = round;
        this.player = player;
     
        
        secondsLeft = getTime();
        timer = new Timer(1000, new ActionListener() {
        	/**
             * Each time the timer fires an event, this method decrements the seconds left.  
             * When the number of seconds reaches 0, the timer is stopped and the round moves to the next turn.
             */
            public void actionPerformed(ActionEvent e) {
            	if (secondsLeft < 1) {
                    timer.stop();
                    round.nextTurn();
                    //TODO fix reset for actual turns
                    secondsLeft = getTime();
                    //TODO what happens if time runs out during land selection?
                } else {
                    secondsLeft--;
                    round.panelUpdate();
                    
                }
            }
        });
    }
    
	/**
	 * finds time of the turn
	 * 
	 * @return time of the turn
	 */
    public int getTime() {
    	int food = player.getFood();
        int requirement = round.getFoodRequirement();
    	if (food >= requirement) {
            return 50;
        } else if (food > 0) {
            return 30;
        } else {
            return 5;
        }
    }
    
    
    /**
     * returns the number of seconds left in the Turn
     *
     * @return the number of seconds left on the timer
     */
    public int getSecondsLeft() {
        return secondsLeft;
    }
    
    /**
     * Starts the time on the turn
     */
    public void start() {
        timer.start();
    }
    
    /**
     * Stops the time on the turn
     */
    public void stop() {
        timer.stop();
        secondsLeft = getTime();
    }
    
    /**
     * Returns the player of the turn
     * @return the player of the turn
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Method that returns the running status of the turn.
     * @return true if the turn is currently going on, false if the turn timer is stopped
     */
    public boolean isRunning() {
        return timer.isRunning();
    }
    
    /**
     * Returns positive if the turn should be before the other turn, negative if the turn should be after the other turn.
     * @return positive if this turn should be first or negative if this turn should be after the other turn
     */
    public int compareTo(Object o) {
        return this.getPlayer().compareTo(((Turn)o).getPlayer());
    }
    
   
    
}
