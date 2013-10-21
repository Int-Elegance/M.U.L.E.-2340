import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;


public class LandSelectionTurn extends Turn {
	
	private int numTurns;
	private boolean passed;
	
	private static final int TIME = 60;

	public LandSelectionTurn(LandSelectionRound round, Player player) {
		super(round, player);
		secondsLeft = TIME;
		passed = false;
	}
	
	public int getTime() {
		return TIME;
	}

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
        timer.restart();
        secondsLeft = getTime();
        numTurns++;
    }

	public void pass() {
		((LandSelectionRound) round).addPass();
		passed = true;
	}
	
	public boolean isPassed() {
		return passed;
	}
}
