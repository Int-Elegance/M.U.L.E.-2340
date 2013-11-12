import java.io.Serializable;

/**
 * @author Team 7
 * Race enum to symbolize Race
 */
public enum Race implements Serializable{
    Human   (600),
    Flapper (1600),
    Bonzoid (1000),
    Ugaite  (1000),
    Buzzite (1000);
    
    private final int startingMoney;
    
    /**
     * Race constructor 
     * 
     * @param startingMoney starting money of race
     */
    private Race(int startingMoney) {
        this.startingMoney = startingMoney;
    }
    
    /**
     * @return starting money of race
     */
    public int getStartingMoney() {
        return startingMoney;
    }

}
