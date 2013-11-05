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
	private Mule mule;
	private int state; //1 for land selection, 2 for mule emplacement, 3 for mule selling, 4 for land selling
	private JButton[][] buttons;
	public GamePanel() {}

	/**
	 * Constructor for the GamePanel class
	 * 
	 * @param map 2d array consisting of tiles that make up board
	 * @param game game object to be played
	 */
	public GamePanel(Tile[][] map, Game game) {
		this.map = map;
		this.game = game;
		state = 1;
	}
	
	public void turnMuleEmplacementOn(Mule mule)
	{
		this.mule = mule;
		state = 2;
	}
	
	public void turnMuleEmplacementOff()
	{
		this.mule = null;
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
		    this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    this.frame.setLocationRelativeTo(null);
		    return true;
		} catch (Exception E) {
			System.out.println(E.getMessage());
			return false;
		}
	}
	
	/**
	 * @author Team 7
	 * Listener class gives the Tile buttons functionality
	 */
	private class TileListener implements ActionListener {
	    private int i;
	    private int j;
	    
	    /**
		 * Constructor for the TileListener class
		 * 
		 * @param i x coordinate of Tile
		 * @param j y coordinate of Tile
		 */
	    public TileListener(int i, int j) {
	        this.i = i;
	        this.j = j;
	    }
	    
	    /**
		 * Performed when a Tile is clicked
		 * 
		 * Gives player property if it isn't owned
		 * Adds border
		 * Moves on to the next turn
		 * 
		 * @param e ActionEvent for the event
		 */
	    public void actionPerformed(ActionEvent e) {
	    	final Property current =  (Property) map[i][j];
	    	if (state == 1)
	    	{
	    		if (game.getCurrentTurn() instanceof LandSelectionTurn && !current.isOwned()) 
	    		{
	    			((LandSelectionTurn) game.getCurrentTurn()).addProperty(current);
	    			Player p = game.getCurrentRound().getCurrentTurn().getPlayer();
	    			buttons[i][j].setBorder(BorderFactory.createLineBorder(p.getColorRepresentation(), 5));
	    			game.nextTurn();
	    		}
	    		else
	    		{
	    			if (state == 2)
	    			{
	    				if (!current.isOwned() || (current.isOwned() && current.getOwner() != mule.getOwner()))
	    				{
	    					mule.getOwner().setMule(null);
	    					System.out.println("Mule not emplaced");
	    					game.nextTurn();
	    				}
	    				else
	    				{
	    					mule.setLocation(current);
	    					System.out.println("Mule emplaced");
	    					game.nextTurn();
	    				}
	    			}
	    		}
	    		}
	        }
	    }
    }

