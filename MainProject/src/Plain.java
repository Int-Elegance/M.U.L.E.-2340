import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * @author Team 7
 * Plain class for the board
 */
public class Plain extends Property implements Serializable {
    
	private static final long serialVersionUID = 12L;

	/**
	 * Plain constructor
	 */
    public Plain() {
        super(2, 3, 1);
        this.display = new ImageIcon(getClass().getResource("resources/plain.jpg"));
        food=2;
        energy=3;
        ore=1;
    }
    
    /**
     * Changes the ImageIcon to one displaying a mule
     */
    public void addMule() {
    	this.display = new ImageIcon(getClass().getResource("resources/plain_mule.jpg"));
    }
    
    
}
