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
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(false);
		layeredPane.setPreferredSize(new Dimension(townWidth, townHeight));
		
		townImage.setBounds(0,0,townWidth, townHeight);
		playerImage.setBounds(playerX,playerY,playerX+playerWidth,playerY+playerHeight);
		
		layeredPane.add(townImage,JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(playerImage,JLayeredPane.POPUP_LAYER);
		
		panel = new JPanel();
		panel.add(layeredPane);
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
	}
	
	/* checks if player is within outer bounds */
	private void checkOuterBoundaries(){
		if(playerX+playerWidth>townWidth){
			playerX=townWidth-playerWidth;
		}
		if(playerX<0){
			playerX=0;
		}
		if(playerY+playerHeight>townHeight){
			playerY=townHeight-playerHeight;
		}
		if(playerY<0){
			playerY=0;
		}
	}

	/* checks if player is inside a shop */
	private void checkInnerBoundaries(){
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
		checkForSpecificLocations(pubX, pubY, pubWidth, pubHeight);
		checkForSpecificLocations(storeX, storeY, storeWidth, storeHeight);
		checkForSpecificLocations(landOfficeX, landOfficeY, landOfficeWidth, landOfficeHeight);
		checkForSpecificLocations(otherX, otherY, otherWidth, otherHeight);
	}
	
	/**
	 * checks if the player is inside a specific location and updates players location to not be inside the specific location
	 * @param locX
	 * @param locY
	 * @param locWidth
	 * @param locHeight
	 */
	private void checkForSpecificLocations(int locX,int locY,int locWidth, int locHeight){
		
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
		KeyStroke stork = new KeyStroke();
		if(frame==null)
			return;
		frame.addKeyListener(stork);
		
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
