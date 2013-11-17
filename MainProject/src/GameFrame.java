/**
 * @author Team 7
 * @date 11/10/13
 */
import java.io.Serializable;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements Serializable
{
	private static final long serialVersionUID = 20L;
	Game game;
	
	public GameFrame(Game game)
	{
		super();
		this.game = game;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println("Creating game frame...");
	}
	
	public void close()
	{
		super.dispose();
	}
	public void dispose()
	{
		System.out.println("dispose game...");
		try
		{
			System.out.println(game.getCurrentTurn().getPlayer().toString());
			Game.SaveGame(game);
		}
		catch (Exception e) {}
		System.exit(EXIT_ON_CLOSE);
		super.dispose();
	}

}
