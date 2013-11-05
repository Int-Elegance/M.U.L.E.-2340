/**
 * @author Team 7
 * Mule class
 */

public class Mule {
    private boolean emplaced;
    private boolean outfitted;
    private Player owner;
    private Property location;
    private int type;
    
    /* We can evaluate if we need basic later */
    public final static int BASIC = 0;
    public final static int FOOD = 1;
    public final static int ENERGY = 2;
    public final static int SMITHORE = 3;
    
    /**
     * Constructor for the Mule class
     * @param owner the owner of the mule
     * @param type the type of the mule, 1 for food, 2 for energy, 3 for smithore
     */
    public Mule(Player owner, int type) {
        this.type = type;
        this.owner = owner;
        this.location = null;
    }
    
    /**
     * returns he type of the mule, 1 for food, 2 for energy, 3 for smithore
     * @return the type of the mule
     */
    public int getType() {
        return type;
    }
    
    /**
     * sets the type of the mule, 1 for food, 2 for energy, 3 for smithore
     * @param the type of the mule
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * returns the property that the mule is placed on
     * @returns the property that the mule is on
     */
    public Property getLocation() {
        return location;
    }
    
    /**
     * Sets the property that mule is placed on
     * @param location the property that the mule is placed on
     */
    public void setLocation(Property location) {
        this.location = location;
    }
    
    public Player getOwner()
    {
    	return owner;
    }
}
