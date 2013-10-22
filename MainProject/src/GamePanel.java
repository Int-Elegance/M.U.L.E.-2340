/**
 * @author Team 7
 * Contains the visual information for the MULE game
 */
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel {
	
	private Tile[][] map;
	private JFrame frame;
	private Game game;
	private JButton[][] buttons;
	public GamePanel() {}

	public GamePanel(Tile[][] map, Game game) {
		this.map = map;
		this.game = game;
	}
	
	/**
	 * 
	 * @param frame The frame on which the visuals will be displayed
	 * @return true if the display has been correctly set up, false if otherwise
	 */
	public boolean beginDisplay(JFrame frame){
		try {
		    this.frame = frame;
		    this.frame.setSize(900, 600);
		    JPanel mainPanel = new JPanel(new BorderLayout());
		    mainPanel.setSize(900, 500);
		    JPanel board = new JPanel(new GridLayout(5, 9));
		    buttons = new JButton[map.length][map[0].length];
		    for (int i = 0; i < map.length; i++) {
		        for (int j = 0; j < map[i].length; j++) {
		        	JButton button = new JButton(map[i][j].getDisplay());
		        	buttons[i][j] = button;
		        	if (map[i][j] instanceof Property) {
			            button.addActionListener(new TileListener(i,j));
		            }
		            board.add(button);
		        } 
		    }
		    NotificationPanel notification = new NotificationPanel(game);
		    game.setNotificationPanel(notification);
		    mainPanel.add(board);
		    mainPanel.add(notification, BorderLayout.SOUTH);
		    this.frame.add(mainPanel);
		    
		    return true;
		} catch (Exception E) {
			System.out.println(E.getMessage());
			return false;
		}
	}
	
	private class TileListener implements ActionListener {
	    private int i;
	    private int j;
	    
	    public TileListener(int i, int j) {
	        this.i = i;
	        this.j = j;
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        final Property current =  (Property) map[i][j];
	        if (game.getCurrentTurn() instanceof LandSelectionTurn && !current.isOwned()) {
			    ((LandSelectionTurn) game.getCurrentTurn()).addProperty(current);
			    Player p = game.getCurrentRound().getCurrentTurn().getPlayer();
			    buttons[i][j].setBorder(BorderFactory.createLineBorder(p.getColorRepresentation(), 5));
			    game.nextTurn();
	        }
	    }
    }
}
