import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.List;

public class NotificationPanel extends JPanel {

	private Game game;
	private JLabel turn;
	private JLabel score;
	private JLabel time;
	private JButton pass;
	private JLabel round;
	
	public NotificationPanel(Game g)
	{
		game = g;
		score = new JLabel();
		time = new JLabel();
		turn = new JLabel();
		round = new JLabel();
		pass = new JButton("Pass");
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCurrentTurn() instanceof LandSelectionTurn) ((LandSelectionTurn) game.getCurrentTurn()).pass();
			}
		});
		
		this.add(round, BorderLayout.SOUTH);
		this.add(turn, BorderLayout.NORTH);
		this.add(score, BorderLayout.CENTER);
		this.add(time, BorderLayout.WEST);
		this.add(pass, BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g)
	{
		Turn currentTurn = game.getCurrentTurn();
		super.paintComponent(g);
		List<Player> players = game.getPlayers();
		String str = "";
		
		for (Player p : players)
		{
			str += p.getName() + " " + p.getMoney() + " ";
		}
		
		round.setText("Current Round: " + currentTurn.round.getRoundNumber());
		turn.setText("Current Turn: " + currentTurn.player.getName());
		score.setText("Score: " + str);
		time.setText("Time Remaining: " + currentTurn.getSecondsLeft());
	}
	
	public void update(){
		this.repaint();
		this.validate();
	}
}
