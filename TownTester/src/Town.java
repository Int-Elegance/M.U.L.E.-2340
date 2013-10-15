import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Town {
	
	private float progress = 0.0f;
	private JLabel playerImage;
	private JLabel townImage;
	private int playerWidth;
	private int playerHeight;
	private int playerX=200;
	private int playerY=200;
	private int townWidth;
	private int townHeight;
	private JPanel panel;
	private JFrame frame;
	private int verticalDirection=0; //false is down
	private int horizontalDirection=0; //false is left
	
	/**
	 * 
	 */
	public Town(){
		//Sets the widths and heights for the player and the town. If the player is set to the correct width odd things happen. 
		//If the player is set to 28x42 it works normally except near the edges.
				
		ImageIcon playerIcon = new ImageIcon("player.jpg");
		playerImage = new JLabel(playerIcon);
		playerWidth=28;//playerIcon.getIconWidth();
		playerHeight=42;//playerIcon.getIconHeight();
		
		ImageIcon townIcon = new ImageIcon("town.jpg");
		townImage = new JLabel(townIcon);
		townWidth=townIcon.getIconWidth();
		townHeight=townIcon.getIconHeight();
		
	}
	
	/**
	 * displays initial town with player in the center of the board
	 * @param frame 
	 */
	public void displayTownSquare(JFrame frame){
		this.frame=frame;
		
		//creates layeredPane
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(false);
		layeredPane.setPreferredSize(new Dimension(townWidth, townHeight));
		
		//sets bounds on images so they can be drawn
		townImage.setBounds(0,0,townWidth, townHeight);
		playerImage.setBounds(playerX,playerY,playerX+playerWidth,playerY+playerHeight);
		
		//adds images to the layeredPane
		layeredPane.add(townImage,JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(playerImage,JLayeredPane.POPUP_LAYER);
		
		//creates a new JPanel, and adds the layered pane to it
		panel = new JPanel();
		panel.add(layeredPane);
		
		//adds the pane to the frame, the JFrame has a grid layout but changing the layout does not seem to help the size problem
		frame.setSize(new Dimension(townWidth, townHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(1,1));
		frame.add(panel);
        frame.pack();
        frame.setVisible(true);
	}
	
	/**
	 * updates player's location
	 */
	public void updatePlayer(){
		//calculate new location		
		checkOuterBoundaries();
		checkInnerBoundaries();
		
		playerImage.setBounds(playerX,playerY,playerX+playerWidth,playerY+playerHeight);
		System.out.println("x "+playerX+" y "+playerY);
	}
	
	/* checks if player is within outer bounds */
	private void checkOuterBoundaries(){
		//if the code is running correctly then the 404 should be replaced by townHeight and the 534 should be replaced by townWidth
		//the 10s should be replaced with 0
		if(playerX+playerWidth>528){
			playerX=528-playerWidth;
		}
		if(playerX<10){
			playerX=10;
		}
		if(playerY+playerHeight>404){
			playerY=404-playerHeight;
		}
		if(playerY<10){
			playerY=10;
		}
	}

	/* checks if player is inside a shop */
	private void checkInnerBoundaries(){
		//hard codes values for the shops
		int pubX=22;
		int pubY=18;
		int pubWidth=156;
		int pubHeight=152;
		int storeX=358;
		int storeY=20;
		int storeWidth=164;
		int storeHeight=154;
		int landOfficeX=28;
		int landOfficeY=274;
		int landOfficeWidth=154;
		int landOfficeHeight=122;
		int otherX=350;
		int otherY=256;
		int otherWidth=170;
		int otherHeight=142;
		
		//checks if the player is in one of the locations
		checkForSpecificLocation(pubX, pubY, pubWidth, pubHeight);
		checkForSpecificLocation(storeX, storeY, storeWidth, storeHeight);
		checkForSpecificLocation(landOfficeX, landOfficeY, landOfficeWidth, landOfficeHeight);
		checkForSpecificLocation(otherX, otherY, otherWidth, otherHeight);
	}
	
	/**
	 * checks if the player is inside a specific location and updates players location to not be inside the specific location
	 * @param locX
	 * @param locY
	 * @param locWidth
	 * @param locHeight
	 */
	private void checkForSpecificLocation(int locX,int locY,int locWidth, int locHeight){
		//This is a very painful read through, basically it checks if the corner of the player overlaps with the corner of the location
		//or if the player is hitting one of the sides of the location
		//I believe this code to be correct
		
		/*checking if corners are overlapping */
		if(playerX+playerWidth>locX&&playerX<locX){
			if(playerY+playerHeight>locY&&playerY<locY){//top right corner of loc
				if(horizontalDirection!=0){
					playerX=locX-playerWidth-1;
				}
				else{
					playerY=locY-playerHeight-1;
				}
			}
			if(playerY<locY+locHeight&&playerY+playerHeight>locY+locHeight){//bottom right corner of loc
				if(horizontalDirection!=0){
					playerX=locX-playerWidth-1;
				}
				else{
					playerY=locY+locHeight+1;
				}
			}
			
		}
		
		if(playerX<locX+locWidth&&playerX+playerWidth>locX+locWidth){
			if(playerY+playerHeight>locY&&playerY<locY){//top left corner of loc
				if(horizontalDirection!=0){
					playerX=locX+locWidth+1;
				}
				else{
					playerY=locY-playerHeight-1;
				}
			}
			if(playerY<locY+locHeight&&playerY+playerHeight>locY+locHeight){//bottom left corner of loc
				if(horizontalDirection!=0){
					playerX=locX+locWidth+1;
				}
				else{
					playerY=locY+locHeight+1;
				}
			}
			
		}
		/*checking if the player is overlapping the location from the size*/
		if(playerY+playerHeight<locY+locHeight&&playerY>locY){
			if(playerX+playerWidth>locX&&playerX<locX){//right side of loc
					playerX=locX-playerWidth-1;
			}
			
		    if(playerX+playerWidth>locX+locWidth&&playerX<locX+locWidth){//left side of loc
		    		playerX=locX+locWidth+1;
		    }
		}
		if(playerX+playerWidth<locX+locWidth&&playerX>locX){
			if(playerY+playerHeight>locY&&playerY<locY){//top side of loc
					playerY=locY-playerHeight-1;
			}
			
		    if(playerY+playerHeight>locY+locHeight&&playerY<locY+locHeight){//bottom side of loc
		    		playerY=locY+locHeight+1;
		    }
		}
	
	}	
	/**
	 * moves player around the screen
	 */
	private void animate() {
		//sets a KeyListener to listen for directions
		KeyStroke stork = new KeyStroke();
		if(frame==null)
			return;
		frame.addKeyListener(stork);
		
		//animates the player moving across the screen at a certain fps
		//also has an unused timer feature that could be used later on in the project.
		final int animationTime = 1000;
        int fps = 30;
        int delay = 1000 / fps;
        final long start = System.currentTimeMillis();
        final Timer timer = new Timer(delay, null);
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final long now = System.currentTimeMillis();
                final long elapsed = now - start;
                progress = (float) elapsed / animationTime;
                updatePlayer();
                if (elapsed >= animationTime) {
                 //   timer.stop();
                }
            }
        });
        timer.start();
    }
	
	public static void main(String[] args){
		Town town = new Town();
		JFrame frame = new JFrame();       
		ImageIcon playerIcon = new ImageIcon("player.jpg");
		town.playerImage = new JLabel(playerIcon);
		
        town.displayTownSquare(frame);
        town.animate();
        
	}
	
	
	private class KeyStroke implements KeyListener{
		
		public void keyTyped(KeyEvent e){}
		public void keyPressed(KeyEvent e){
			//Listens for key storkes.
			//Updates the player location.
			//Monitors which direction the player is going in, currently this is being used to decide information about 
			//the movement of the player around the corners of locations in the checkForSpecificLocation() method.
			//Given time a better method of moving around corners should be devised.
			 if(KeyEvent.VK_UP==e.getKeyCode()||KeyEvent.VK_W==e.getKeyCode()){
				 playerY-=2;
				 verticalDirection=-1;
				 horizontalDirection=0;
			 }
			 else if(KeyEvent.VK_DOWN==e.getKeyCode()||KeyEvent.VK_S==e.getKeyCode()){
				 playerY+=2;
				 verticalDirection=1;
				 horizontalDirection=0;
			 }
			 else if(KeyEvent.VK_RIGHT==e.getKeyCode()||KeyEvent.VK_D==e.getKeyCode()){
				 playerX+=2;
				 verticalDirection=0;
				 horizontalDirection=1;
			 }
			 else if(KeyEvent.VK_LEFT==e.getKeyCode()||KeyEvent.VK_A==e.getKeyCode()){
				 playerX-=2;
				 verticalDirection=0;
				 horizontalDirection=-1;
			 }
		 }
		 public void keyReleased(KeyEvent e){}
	}
}
