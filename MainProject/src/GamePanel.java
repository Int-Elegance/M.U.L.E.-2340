import java.util.List;

import javax.swing.*;

public class GamePanel {
	
	private List<String> map;
	
	private JFrame frame;
	
	public GamePanel()
	{
		
	}

	public GamePanel(List<String> map)
	{
		this.map = map;
	}
	
	public boolean beginDisplay(JFrame frame){
		this.frame = frame;
		this.frame.setSize(800, 550);
		ImageIcon mainScreen = new ImageIcon("mainscreen.jpg");
		JLabel label = new JLabel(mainScreen);
		JPanel panel = new JPanel();
		panel.add(label);
		this.frame.add(panel);
		
		return true;
	}

}
