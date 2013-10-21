/**
 * @author Team 7
 * Handles the initialization of the game on the login screen
 */

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
import java.util.List;

public class Login {
	
	//TODO add actual map and difficulty to different classes
	private String difficulty;
	private String mapType;
	private int numPlayers;
	private boolean complete;
	private Game game;
	private JFrame Login;
	private List<Player> players;


	/**
	 * Create the application.
	 * @param game The game associated with this initialization
	 */
	public Login(Game game) {
		complete=false;
		players = new ArrayList<Player>();
		this.game = game;
		initialize();
		this.Login.pack();
		this.Login.setSize(450, 250);
		this.Login.setVisible(true);
	}
	
	/**
	 * @return The difficulty level of the game
	 */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * @return The map associated with the game associated with this login
	 */
	public String getMapType() {
		return mapType;
	}

	/**
	 * @return The number of players
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 *TODO: Evaluate if this is needed?
	 * @return This instance
	 */
	public JFrame getLogin() {
		return Login;
	}

	/**
	 * @return the list of players playing the game
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Creates a main login JFrame container that uses CardLayout to display the different Panels that
	 * will be used throughout the method
	 * 
	 * There is then a panel created for the initial login screen and one for each player in the game
	 * Each panel the necessary information and a button that will store the data and proceed to the
	 * next screen
	 * 
	 * These panels are added to the JFrame's CardLayout
	 * 
	 * When there are no more panels on the CardLayout, it will move on to the main game screen
	 * 
	 */
	private void initialize() {
		Login = new JFrame();
		Login.setTitle("M.U.L.E.\r\n");
		final CardLayout cl = new CardLayout();
		Login.getContentPane().setLayout(cl);
				
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
				//TODO add to respective class
				difficulty = (String)difficultyBox.getSelectedItem();
				mapType = (String) mapBox.getSelectedItem();
				numPlayers = (Integer) (numPlayerBox.getValue());
				// Create an input panel for each player
				for (int i = 0; i < numPlayers; i++) {
					Player newPlayer = new Player();
					players.add(newPlayer);
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
	
	/**
	 * Creates a panel that prompts for input information for each player
	 * 
	 * Stores the inputed information into the player parameter
	 * 
	 * @param p player to store the information to
	 * @param num number associated with player
	 * @param cl CardLayout to get the next panel from
	 */
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
		raceBox.setModel(new DefaultComboBoxModel(Game.RACES));
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
		colorBox.setModel(new DefaultComboBoxModel(Game.COLORS.toArray()));
		colorBox.setBounds(226, 128, 69, 20);
		playerPanel.add(colorBox);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setRace((Race)raceBox.getSelectedItem());
				p.setName(nameField.getText());
				p.setColor((String) colorBox.getSelectedItem());
				if (num == numPlayers - 1) {
					Login.getContentPane().removeAll();
					game.loginComplete(Login);
					return;
				} else {
					cl.next(Login.getContentPane());
				}
			}
		});
		button.setBounds(106, 154, 89, 23);
		playerPanel.add(button);
	}
}
