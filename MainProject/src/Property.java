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
    
    public Property(int food, int energy, int ore) {
        this.food = food;
        this.energy = energy;
        this.ore = ore;
        this.isOwned = false;
    }
    
    public boolean isOwned() {
    	return isOwned;
    }
    
    public void setOwned(boolean b) {
    	isOwned = b;
    }
}
