import javax.swing.ImageIcon;

/**
 * @author Team 7
 * abstract Tile class for game board
 */
public abstract class Tile {
    private int x;
    private int y;
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
