import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.util.ArrayList;


public class Login {
	
	//TODO add actual map and difficulty to different classes
	private String difficulty;
	private String mapType;
	private int numPlayers;

	private JFrame Login;
	private JTextField nameField;
	private ArrayList<String> colors = new ArrayList<>();
	private ArrayList<String> races = new ArrayList<>();
	
	private Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.Login.pack();
					window.Login.setSize(450, 250);
					window.Login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		colors.add("Yellow");
		colors.add("Orange");
		colors.add("Purple");
		
		races.add("Human");
		races.add("Flapper");
		races.add("Bonzoid");
		races.add("Ugaite");
		races.add("Buzzite");
		
		Login = new JFrame();
		Login.setTitle("Login\r\n");
		final CardLayout cl = new CardLayout();
		Login.getContentPane().setLayout(cl);
		
		game = new Game();
		
		JPanel login = new JPanel();
		Login.getContentPane().add(login, "login");
		login.setLayout(null);
		
		JLabel lblWelcomeToMule = new JLabel("Welcome to MULE!");
		lblWelcomeToMule.setBounds(106, 25, 162, 14);
		login.add(lblWelcomeToMule);
		
		JLabel lblSelectDifficulty = new JLabel("Difficulty");
		lblSelectDifficulty.setBounds(106, 79, 89, 14);
		login.add(lblSelectDifficulty);
		
		final JComboBox difficultyBox = new JComboBox();
		difficultyBox.setBounds(226, 76, 83, 20);
		difficultyBox.setModel(new DefaultComboBoxModel(new String[] {"Beginner", "Standard", "Tournament"}));
		login.add(difficultyBox);
		
		JLabel lblSelectMapType = new JLabel("Map Type");
		lblSelectMapType.setBounds(106, 105, 89, 14);
		login.add(lblSelectMapType);
		
		final JComboBox mapBox = new JComboBox();
		mapBox.setBounds(226, 102, 100, 20);
		mapBox.setModel(new DefaultComboBoxModel(new String[] {"Standard", "Random"}));
		login.add(mapBox);
		
		JLabel lblNumberOfPlayers = new JLabel("Number of Players");
		lblNumberOfPlayers.setBounds(106, 131, 110, 14);
		login.add(lblNumberOfPlayers);
		
		final JSpinner numPlayerBox = new JSpinner();
		numPlayerBox.setBounds(226, 128, 31, 20);
		numPlayerBox.setModel(new SpinnerNumberModel(2, 2, 4, 1));
		login.add(numPlayerBox);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO add to respective cl
				difficulty = (String)difficultyBox.getSelectedItem();
				mapType = (String) mapBox.getSelectedItem();
				numPlayers = (int) numPlayerBox.getValue();
				for (int i = 0; i < numPlayers; i++) {
					Player newPlayer = new Player(null, null, 0, null, null);
					game.addPlayer(newPlayer);
					generatePlayerPanel(newPlayer, i, cl);
				}
				cl.next(Login.getContentPane());
			}
		});
		btnEnter.setBounds(106, 154, 89, 23);
		login.add(btnEnter);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your settings");
		lblPleaseEnterYour.setBounds(106, 42, 151, 14);
		login.add(lblPleaseEnterYour);
	}
	
	private void generatePlayerPanel(final Player p, final int num, final CardLayout cl){
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(null);
		Login.getContentPane().add(playerPanel, ""+ num);
		
		JLabel titleLabel = new JLabel("Player "+(num+1)+" Attributes");
		titleLabel.setBounds(106, 31, 130, 14);
		playerPanel.add(titleLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(106, 79, 89, 14);
		playerPanel.add(nameLabel);
		
		JLabel raceLabel = new JLabel("Race");
		raceLabel.setBounds(106, 105, 89, 14);
		playerPanel.add(raceLabel);
		
		final JComboBox raceBox = new JComboBox();
		raceBox.setModel(new DefaultComboBoxModel(races.toArray()));
		raceBox.setBounds(226, 102, 69, 20);
		playerPanel.add(raceBox);
		
		JLabel colorLabel = new JLabel("Color");
		colorLabel.setBounds(106, 131, 89, 14);
		playerPanel.add(colorLabel);
		
		final JTextField nameField = new JTextField();
		nameField.setBounds(223, 76, 111, 20);
		playerPanel.add(nameField);
		nameField.setColumns(10);
		
		final JComboBox colorBox = new JComboBox();
		colorBox.setModel(new DefaultComboBoxModel(colors.toArray()));
		colorBox.setBounds(226, 128, 69, 20);
		playerPanel.add(colorBox);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setRace(races.indexOf((String)raceBox.getSelectedItem()));
				p.setName(nameField.getText());
				p.setColor((String) colorBox.getSelectedItem());
				if (num == numPlayers - 1) {
					//TODO show main game screen
				} else {
					cl.next(Login.getContentPane());
				}
			}
		});
		button.setBounds(106, 154, 89, 23);
		playerPanel.add(button);
		
	}
}
