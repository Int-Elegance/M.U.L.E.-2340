import javax.swing.*;

import java.awt.event.*;
import java.io.Serializable;

/**
 * This class takes care of the turn for a player and keeps track of the time passing.
 * @author Team 7
 */

public class Turn implements Comparable<Turn>, Serializable {
    
	private static final long serialVersionUID = 1L;
	protected Timer timer;
    protected int secondsLeft;
    protected Round round; 
    protected Player player;
    protected boolean passed;
    
    
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
        secondsLeft = getTime(false);
        
    	
        
        timer = new Timer(1000, new ActionListener() {
        	
        	
        	
        	/**
             * Each time the timer fires an event, this method decrements the seconds left.  
             * When the number of seconds reaches 0, the timer is stopped and the round moves to the next turn.
             */
            public void actionPerformed(ActionEvent e) {
            	if (secondsLeft < 1) {
                    endTurn();
                } else {
                    secondsLeft--;
                    round.panelUpdate();
                    
                }
            }
        });
    }
    
    /**
     * Method that immediately ends turn, regardless of how many seconds are left
     */
    public void endTurn() {
    	secondsLeft = 0;
    	timer.stop();
    	// if the player still has a mule in his/her inventory at the end of the turn
		if (player.getMule()!=null) {
			JOptionPane.showMessageDialog(new JDialog(), "You ran out of time...So you lost your mule!");
			player.setMule(null); // fixes bug where player can't buy mules after not placing one last turn
		}
        Game game = round.getGame();
		game.getCurrentTurn().pass();
		game.nextTurn();
        //TODO fix reset for actual turns
        secondsLeft = getTime(false);
    }
    

    /**
     * Calculates the time that the players has depending on food
     * @return the time in the seconds that the player has
     */
    public int getTime(boolean deductRequirement) {
    	int food = player.getFood();
        int requirement = round.getFoodRequirement();
    	if (food >= requirement) {
    		if(deductRequirement){
    			player.setFood(food-requirement);
    		}
            return 50;
        } else if (food > 0) {
        	if(deductRequirement){
        		player.setFood(0);
        	}
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
   
    public void restart()
    {
    	timer = new Timer(1000, new ActionListener() {
    	
    	/**
         * Each time the timer fires an event, this method decrements the seconds left.  
         * When the number of seconds reaches 0, the timer is stopped and the round moves to the next turn.
         */
        public void actionPerformed(ActionEvent e) {
        	if (secondsLeft < 1) {
                endTurn();
            } else {
                secondsLeft--;
                round.panelUpdate();
                
            }
        }
    });
    }
    /**
     * Stops the time on the turn
     */
    public void stop() {
        timer.stop();
        secondsLeft = getTime(false);
    }
    
    /**
     * Returns the player of the turn
     * @return the player of the turn
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Returns the current round of the turn
     * @return round
     */
    public Round getRound() {
    	return round;
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
    public int compareTo(Turn o) {
        return this.getPlayer().compareTo(o.getPlayer());
    }
    
    /**
     * indicates the turn has been passed
     */
    public void pass()
    {
    	passed = true;
    }
    
    /**
     * @return if the turn has been passed
     */
    public boolean isPassed()
    {
    	return passed;
    }
    
}
