/**
 * @author Team 7
 * Contains the visual information for the MULE game
 */
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class GamePanel {
	
	private Tile[][] map;
	private JFrame frame;
	
	public GamePanel() {}

	public GamePanel(Tile[][] map) {
		this.map = map;
	}
	
	/**
	 * 
	 * @param frame The frame on which the visuals will be displayed
	 * @return true if the display has been correctly set up, false if otherwise
	 */
	public boolean beginDisplay(JFrame frame){
		try {
		    this.frame = frame;
		    this.frame.setSize(900, 500);
		    JPanel panel = new JPanel(new GridLayout(5, 9));
		    for (int i = 0; i < map.length; i++) {
		        for (int j = 0; j < map[i].length; j++) {
		            panel.add(new JButton(map[i][j].getDisplay()));
		        } 
		    }
		    this.frame.add(panel);
		    return true;
		} catch (Exception E) {
			return false;
		}
	}
}
