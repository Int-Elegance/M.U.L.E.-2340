import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RandomEvent implements Serializable{

	private static final long serialVersionUID = 9L;
	public static final int EVENT_CHANCE = 27;
	public static final int MAX_EVENT_CHANCE = 100;
	private static Random rand;
	private static RandomEvent re;
	private static List<Player> players;

	private static int[] scalar = { 25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75,
			100 };

	private static String[] turnEvents = {
			"YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.",
			"A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.",
			"THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $",
			"YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $",
			"FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $",
			"MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.",
			"YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. TO CLEAN IT UP IT COST YOU $" };
	private static boolean[] turnGoodEvents = { true, true, true, true, false,
			false, false };

	private static String[] roundEvents = {
			"THERE HAS BEEN A BOUNTIFUL HARVEST EVERY PLAYER RECEIVES 3 FOOD.",
			"TAX SEASON! EVERYONE PAYS $300 TO KEEP THE TOWN RUNNING.",
			"YELLOW JACKETS HAVE WON A FOOTBALL GAME EVERY PLAYER RECEIVES 2 ORE!" };
	private static boolean[] roundGoodEvents = { true, false, true };

	private RandomEvent(List<Player> players) {
		rand = new Random();
		addPlayerList(players);
	}

	private static void addPlayerList(List<Player> players) {
		re.players = players;
	}

	public static void roundEventOccur(JFrame frame, List<Player> players) {

		if (re == null) {
			re = new RandomEvent(players);
		}
		int money = players.get(0).getMoney();
		for (Player p : players) {// find player with lowest money
			if (p.getMoney() < money) {
				money = p.getMoney();
			}
		}
		
		int currEventChance = rand.nextInt(MAX_EVENT_CHANCE);
	//	System.out.println("Random event chance: "+currEventChance);
		if (currEventChance < EVENT_CHANCE) {
			int eventNum = rand.nextInt(roundEvents.length);

			if (eventNum == 0) {
				JOptionPane.showMessageDialog(frame, roundEvents[eventNum]);
			} else if (eventNum == 1) {
				JOptionPane.showMessageDialog(frame, roundEvents[eventNum]);
			} else if (eventNum == 2) {
				JOptionPane.showMessageDialog(frame, roundEvents[eventNum]);
			}

			for (Player p : players) {
				if (eventNum == 0) {
					p.setFood(p.getFood() + 3);
				} else if (eventNum == 1 && p.getMoney() != money) {
					p.changeMoney(p.getMoney() - 300);
				} else if (eventNum == 2) {
					p.setSmithore(p.getSmithore() + 2);
				}
			}
		}
	}

	public static void turnEventOccur(JFrame frame, List<Player> players,
			Player player) {

		if (re == null) {
			re = new RandomEvent(players);
		}

		int money = player.getMoney();
		for (Player p : players) {// find player with lowest money
			if (p.getMoney() < money) {
				money = p.getMoney();
			}
		}
		int currEventChance = rand.nextInt(MAX_EVENT_CHANCE);
		if (currEventChance < EVENT_CHANCE) {
			int eventNum = rand.nextInt(turnEvents.length);
			if (turnGoodEvents[eventNum] == false && player.getMoney() == money) {
				return;
			} else {
				
				
				if (eventNum == 0) {
					player.setFood(player.getFood() + 3);
					player.setEnergy(player.getEnergy() + 2);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum]);
				} else if (eventNum == 1) {
					player.setSmithore(player.getSmithore() + 2);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum]);
				} else if (eventNum == 2) {
					player.setMoney(player.getMoney() + 8 * scalar[eventNum]);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum] + 8
							* scalar[eventNum] + ".");
				} else if (eventNum == 3) {
					player.setMoney(player.getMoney() + 2 * scalar[eventNum]);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum] + 2
							* scalar[eventNum] + ".");
				} else if (eventNum == 4) {
					player.changeMoney(player.getMoney() - 4 * scalar[eventNum]);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum] + 4
							* scalar[eventNum] + ".");
				} else if (eventNum == 5) {
					player.setFood(player.getFood() / 2);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum]);
				} else if (eventNum == 6) {
					player.changeMoney(player.getMoney() - 6 * scalar[eventNum]);
					JOptionPane.showMessageDialog(frame, player.getName()
							+ ": " + turnEvents[eventNum] + 6
							* scalar[eventNum] + ".");
				}

			}
		}

	}
}
