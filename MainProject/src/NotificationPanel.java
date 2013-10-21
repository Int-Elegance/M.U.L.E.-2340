import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.List;

public class NotificationPanel extends JPanel {

	private Game game;
	private JLabel score;
	private JLabel time;
	private JButton pass;
	
	public NotificationPanel(Game g)
	{
		game = g;
		score = new JLabel();
		time = new JLabel();
		pass = new JButton("Pass");
		pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCurrentTurn() instanceof LandSelectionTurn) ((LandSelectionTurn) game.getCurrentTurn()).pass();
			}
		});
		this.add(score, BorderLayout.NORTH);
		this.add(time, BorderLayout.WEST);
		this.add(pass, BorderLayout.EAST);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		List<Player> players = game.getPlayers();
		String str = "";
		
		for (Player p : players)
		{
			str += p.getName() + " " + p.getMoney() + " ";
		}
		
		score.setText("Score: " + str);
		time.setText("Time Remaining: " + game.getCurrentTurn().getSecondsLeft());
	}
}
