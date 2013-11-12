import java.io.Serializable;


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
	
	
	public static int getFoodQuantity() {
		return foodQuantity;
	}
	public static void setFoodQuantity(int foodQuantity) {
		Store.foodQuantity = foodQuantity;
	}
	public static int getEnergyQuantity() {
		return energyQuantity;
	}
	public static void setEnergyQuantity(int energyQuantity) {
		Store.energyQuantity = energyQuantity;
	}
	public static int getMuleQuantity() {
		return muleQuantity;
	}
	public static void setMuleQuantity(int muleQuantity) {
		Store.muleQuantity = muleQuantity;
	}
	public static int getSmithoreQuantity() {
		return smithoreQuantity;
	}
	public static void setSmithoreQuantity(int smithoreQuantity) {
		Store.smithoreQuantity = smithoreQuantity;
	}
	public int getFOOD_COST() {
		return FOOD_COST;
	}
	public int getENERGY_COST() {
		return ENERGY_COST;
	}
	public int getSMITHORE_COST() {
		return SMITHORE_COST;
	}
	public int getFOOD_MULE_COST() {
		return FOOD_MULE_COST;
	}
	public int getENERGY_MULE_COST() {
		return ENERGY_MULE_COST;
	}
	public int getSMITHORE_MULE_COST() {
		return SMITHORE_MULE_COST;
	}
	
	
	
}
