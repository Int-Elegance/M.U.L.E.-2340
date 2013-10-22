import javax.swing.ImageIcon;

/**
 * Class representing the Town tile type.  
 */
public class Town extends Tile {
    /**
     * Contructor for town that sets the default town image
     */
    public Town() {
        this.display = new ImageIcon("town.jpg");
    }
}
