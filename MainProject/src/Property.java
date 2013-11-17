import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * Property is a Tile that can be owned by a Player
 * @author Team 7
 *
 */
public abstract class Property extends Tile implements Serializable{
	
	private static final long serialVersionUID = 10L;
	private Player owner;
    private boolean isOwned;
    private Mule mule;
    protected int food;
    protected int energy;
    protected int ore;
    
    /**
	 * Property constructor
	 * 
	 * @param amount of food of property
	 * @param amount of money of property 
	 * @param amount of ore of property
	 */
    public Property(int food, int energy, int ore) {
        this.food = food;
        this.energy = energy;
        this.ore = ore;
        this.isOwned = false;
    }
    
    /**
	 * @return if the property is owned
	 */
    public boolean isOwned() {
    	return isOwned;
    }
    
    /**
	 * Puts a mule on this property
	 * 
	 * @param mule to put on the property
	 * @return false if there is a mule in place on this property, true otherwise
	 */
    public boolean setMule(Mule mule) {
    	boolean toReturn;
    	// if there is not a mule in place here
    	if (this.mule == null) {
    		this.mule = mule;
    		toReturn = true;
    	}
    	// if there is a mule in place here
    	else {
    		toReturn = false;
    	}
    	return toReturn;
    }
    
    /**
	 * @param b true if property is owned
	 */
    public void setOwned(boolean b) {
    	isOwned = b;
    }
    
    /**
     * sets the owner of this property
     * 
	 * @param p player to be the owner
	 */
    public void setOwner(Player p)
    {
    	this.owner = p;
    }
    

    /**
	 * @return the owner of the mule
	 */
    public Player getOwner()
    {
    	return owner;
    }
    
    /**
     * updates the resources of a player given the resources and mules on the property
     * 
	 * @param mule that will determine the players resources
	 */
    public void updatePlayerResources(Mule mule){
    	if (mule != null) {
    	    int type = mule.getType();
	    	Player player = mule.getOwner();
    	    if (type == Mule.FOOD) {
	    	    player.setFood(player.getFood() + food);
	        } else if (type == Mule.ENERGY) {
	            player.setEnergy(player.getEnergy() + energy);
            } else {
	    	    player.setSmithore(player.getSmithore() + ore);
	        }
    	}
    }
    
}
