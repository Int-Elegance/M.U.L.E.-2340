/**
 * @author Team 7
 * Contains the visual information for the MULE game
 */
import java.util.List;
import javax.swing.*;

public class GamePanel {
	
	private List<String> map;
	private JFrame frame;
	
	public GamePanel() {}

	public GamePanel(List<String> map) {
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
		this.frame.setSize(800, 550);
		ImageIcon mainScreen = new ImageIcon("mainscreen.jpg");
		JLabel label = new JLabel(mainScreen);
		JPanel panel = new JPanel();
		panel.add(label);
		this.frame.add(panel);
		return true;
		}
		
		catch (Exception E) {
			return false;
		}
	}
}
