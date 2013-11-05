import javax.swing.ImageIcon;

/**
 * @author Team 7
 * Plain class for the board
 */
public class Plain extends Property {
    
	/**
	 * Plain constructor
	 */
    public Plain() {
        super(2, 3, 1);
        this.display = new ImageIcon(getClass().getResource("resources/plain.jpg"));
    }
    
    /**
     * Changes the ImageIcon to one displaying a mule
     */
    public void addMule() {
    	this.display = new ImageIcon(getClass().getResource("resources/plain_mule.jpg"));
    }
}
