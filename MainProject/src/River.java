import javax.swing.ImageIcon;

/**
 * @author Team 7
 * River class for board
 */
public class River extends Property {
    
	/**
	 * @author Team 7
	 * River constructor
	 */
    public River() {
        super(4, 2, 0);
        this.display = new ImageIcon(getClass().getResource("resources/river.jpg"));
        food=4;
        energy=2;
        ore=0;
    }
    
    /**
     * Changes the ImageIcon to one displaying a mule
     */
    public void addMule() {
    	this.display = new ImageIcon(getClass().getResource("resources/river_mule.jpg"));
    }
    
}
