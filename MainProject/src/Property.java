/**
 * Property is a Tile that can be owned by a Player
 * @author Team 7
 *
 */
public abstract class Property extends Tile {
    private Player owner;
    private boolean isOwned;
    private Mule mule;
    private int food;
    private int energy;
    private int ore;
    
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
    
    public void setMule(Mule mule) {
        this.mule = mule;
    }
    
    /**
	 * @param b true if property is owned
	 */
    public void setOwned(boolean b) {
    	isOwned = b;
    }
    
    public void setOwner(Player p)
    {
    	this.owner = p;
    }
    
    public Player getOwner()
    {
    	return owner;
    }
}
