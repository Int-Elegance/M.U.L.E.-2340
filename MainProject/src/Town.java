import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * @author Team 7
 * Town class for game board
 */
public class Town extends Tile implements Serializable {

	 
	private static final long serialVersionUID = 4L;

	/**
     * Contructor for town that sets the default town image
     */
    public Town() {
        this.display = new ImageIcon(getClass().getResource("resources/town.jpg"));
    }
}
