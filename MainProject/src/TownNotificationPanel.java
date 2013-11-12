import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;
import java.util.List;

/**
 * @author Team 7
 * NotificationPanel class to display info at the bottom of the screen
 */
public class TownNotificationPanel extends JPanel implements Serializable{

	private static final long serialVersionUID = 3L;
	private Turn currentTurn;
	private JLabel turn;
	private JLabel score;
	private JLabel time;
	
	/**
	 * NotificationPanel constructor
	 * Initializes labels and buttons
	 * @param g the game to be played
	 */
	public TownNotificationPanel(Turn t)
	{
		this.currentTurn = t;
		score = new JLabel();
		time = new JLabel();
		turn = new JLabel();
		this.add(turn, BorderLayout.NORTH);
		this.add(score, BorderLayout.CENTER);
		this.add(time, BorderLayout.WEST);
	}
	
	/**
	 * Sets up labels and buttons
	 * 
	 * @param g Graphics object to paint on
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		String str = "";
		Player p = currentTurn.getPlayer();
		str += p.getName() + " " + p.getMoney() + " ";
		
		turn.setText("Current Turn: " + currentTurn.player.getName());
		score.setText("|  Money: " + p.getMoney() + " | Food: " + p.getFood() + " | Energy: " + p.getEnergy() + " | Smithore: " + p.getSmithore() + " |");
		time.setText("Time Remaining: " + currentTurn.getSecondsLeft());
	}
	
	/**
	 * repaints the NotificationPanel
	 */
	public void update(){
		System.out.println("updating town notification panel");
		this.repaint();
		this.validate();
	}
}
