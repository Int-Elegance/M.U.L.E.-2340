import java.io.Serializable;

/**
 * @author Team 7
 * The store for the game that keeps track of the resources
 */
public class Store implements Serializable{
	
	private static final long serialVersionUID = 6L;
	private static int foodQuantity;
	private static int energyQuantity;
	private static int muleQuantity;
	private static int smithoreQuantity;
	private final int FOOD_COST = 30;
	private final int ENERGY_COST = 25;
	private final int SMITHORE_COST = 50;
	private final int FOOD_MULE_COST = 125;
	private final int ENERGY_MULE_COST = 150;
	private final int SMITHORE_MULE_COST = 175;
	private static boolean firstTime=true;
	
	/**
	 * Constructor for the Store class
	 * sets the resources based on the difficulty
	 * 
	 * @param beginner true if the difficulty is beginner
	 */
	public Store(boolean beginner){
		System.out.println("store");
		if(beginner&&firstTime){
			System.out.println("first");
			foodQuantity = 16;
			energyQuantity = 16;
			muleQuantity = 25;
			smithoreQuantity = 0;
		}
		else if(!beginner&&firstTime){
			System.out.println("first");
			foodQuantity = 8;
			energyQuantity = 8;
			muleQuantity = 14;
			smithoreQuantity = 8;
		}
		else{
			System.out.println("not first");
		}
		firstTime=false;
	}
	
	/**
	 * @return the food quantity of the store
	 */
	public static int getFoodQuantity() {
		return foodQuantity;
	}
	
	/**
	 * sets the food quantity for the store
	 * 
	 * @param the food quantity
	 */
	public static void setFoodQuantity(int foodQuantity) {
		Store.foodQuantity = foodQuantity;
	}
	
	/**
	 * @return the energy quantity of the store
	 */
	public static int getEnergyQuantity() {
		return energyQuantity;
	}
	
	/**
	 * sets the energy quantity for the store
	 * 
	 * @param the energy quantity
	 */
	public static void setEnergyQuantity(int energyQuantity) {
		Store.energyQuantity = energyQuantity;
	}
	
	/**
	 * @return the mule quantity of the store
	 */
	public static int getMuleQuantity() {
		return muleQuantity;
	}
	
	/**
	 * sets the mule quantity for the store
	 * 
	 * @param the mule quantity
	 */
	public static void setMuleQuantity(int muleQuantity) {
		Store.muleQuantity = muleQuantity;
	}
	
	/**
	 * @return the smithore quantity of the store
	 */
	public static int getSmithoreQuantity() {
		return smithoreQuantity;
	}
	
	/**
	 * sets the smithore quantity for the store
	 * 
	 * @param the smithore quantity
	 */
	public static void setSmithoreQuantity(int smithoreQuantity) {
		Store.smithoreQuantity = smithoreQuantity;
	}
	
	/**
	 * @return the cost for food
	 */
	public int getFOOD_COST() {
		return FOOD_COST;
	}
	
	/**
	 * @return the cost for energy
	 */
	public int getENERGY_COST() {
		return ENERGY_COST;
	}
	
	/**
	 * @return the cost for smithore
	 */
	public int getSMITHORE_COST() {
		return SMITHORE_COST;
	}
	
	/**
	 * @return the cost for a food mule
	 */
	public int getFOOD_MULE_COST() {
		return FOOD_MULE_COST;
	}
	
	/**
	 * @return the cost for a energy mule
	 */
	public int getENERGY_MULE_COST() {
		return ENERGY_MULE_COST;
	}
	
	/**
	 * @return the cost for a smithore mule
	 */
	public int getSMITHORE_MULE_COST() {
		return SMITHORE_MULE_COST;
	}
	
	
	
}
