import java.util.*;

/**
 * This class is responsible for creating a warehouse at a designated location that contains trucks and has the capability to dispatch trucks to deliver cargo.
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class Warehouse extends Vertex
{
    private int radius;
    private ArrayList<Truck> trucks;
    private ArrayList<CoffeeShop> allShops;
    private int totalDistance = 0;
    
    /**
     * Constructor for objects of class Warehouse
     */
    public Warehouse(int x, int y, int ID, int edges, int numTrucks, int capacity, int radius){
        super(x,y,ID, edges); //call vertex constructor
        this.radius = radius;
        allShops = new ArrayList<CoffeeShop>();
        trucks = new ArrayList<Truck>();
        addTrucks(numTrucks, capacity, radius); //add in all the trucks with the designated capacity into an array
    }
    
    /**
     * adds in all the trucks with a designated capacity into an array for storage
     * 
     * @param  numTrucks   number of trucks to add
     * @param  capacity   weight capacity of each truck
     */
    private void addTrucks(int numTrucks, int capacity, int radius) {
        for (int i = 0; i < numTrucks; i++) {
            trucks.add(new Truck(capacity, this, radius)); //add in new truck with designated capacity and warehouse
        }
    }
    
    /**
     * gets all the shops in the given delivery radius of the warehouse and adds them to an array
     */
    public void getShops() {
        for (int i = 0; i < e.length; i++) { //go through inherited edges array
            if (e[i] != null) {
                CoffeeShop temp = (CoffeeShop) e[i].getEnd();
                allShops.add(temp);
            }
        }
    }
    
    /**
     * dispatches all of the trucks a warehouse has and calculates distance travelled
     * 
     * @return  int, returns the total distance travelled by the trucks at a warehouse
     */
    public int dispatchTrucks(){
        for(int i = 0; i < trucks.size(); i++){
            System.out.println("    Truck " + (i + 1) + " dispatched from Warehouse at (" + x + ", " + y + "):");
            totalDistance += trucks.get(i).planRoute();
        }
        return totalDistance;
    }
    
    /**
     * returns an array of all the shops
     * 
     * @return  ArrayList, returns an arrayList of all of the shops
     */
    public ArrayList<CoffeeShop> returnShops(){
        return allShops;
    }
    
    /**
     * This methods "removes" a piece of cargo by making it's boolean value false
     * 
     * @param  cargoNum   number slot of the cargo to remove
     * @param  storeNum   store to remove the cargo from
     */
    public void removeCargo(int cargoNum, int storeNum) {
        CoffeeShop temp = (CoffeeShop) e[storeNum].getEnd();
        temp.getCargo().get(cargoNum).setIsDone(true);
    }
    
    /**
     * This method "removes" a store by making it's boolean value false
     * 
     * @param  storeNum   number of the store to remove
     */
    
    public void removeStore(int storeNum) {
        CoffeeShop temp = (CoffeeShop) e[storeNum].getEnd();
        temp.setIsDone(true);
    }
}