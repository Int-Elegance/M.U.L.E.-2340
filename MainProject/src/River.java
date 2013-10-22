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
        this.display = new ImageIcon("river.jpg");
    }
    
}
