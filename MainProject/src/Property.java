public abstract class Property extends Tile {
    private Player owner;
    private Mule mule;
    private int food;
    private int energy;
    private int ore;
    
    public Property(int food, int energy, int ore) {
        this.food = food;
        this.energy = energy;
        this.ore = ore;
    }
    
}
