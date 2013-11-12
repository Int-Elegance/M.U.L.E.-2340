import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * @author Team 7
 * abstract Tile class for game board
 */
public abstract class Tile implements Serializable{

	private static final long serialVersionUID = 5L;
	protected ImageIcon display;
    
    /**
     * gets image for display
     * 
     * @return image for display
     */
    public ImageIcon getDisplay() {
        return display;
    }
    
    
    
}
