import java.awt.*;
import javax.swing.*;
import java.util.List;

public class NotificationPanel extends JPanel {

	private Game game;
	private JLabel score;
	
	public NotificationPanel(Game g)
	{
		game = g;
		score = new JLabel();
		this.add(score);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		List<Actor> players = game.getPlayers();
		String str = "";
		
		for (Actor a : players)
		{
			if (a instanceof Player)
			{
				Player p = (Player)a;
				str += p.getName() + " " + ((Player)a).getScore() + " ";
			}
		}
		
		score.setText("Score: " + str);
	}
}
