import java.util.*;

/**
 * This class is responsible for constructing a truck with a designated capacity at a designated warehouse. It has the capability to plan its route until it reaches the capacity of cargo it can
 * handle.
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class Truck
{
    private int capacity;
    private Warehouse homeWarehouse;
    private boolean[] visitedStore;
    private int distance = 0;
    private int x,y;
    private ArrayList<CoffeeShop> shops;
    private ArrayList<CoffeeShop> shopsCopy;
    private int radius;

    /**
     * Constructor for objects of class Truck
     * 
     */
    public Truck(int capacity, Warehouse homeWarehouse, int radius) {
        this.capacity = capacity;
        this.homeWarehouse = homeWarehouse;
        this.radius = radius;
        shops = homeWarehouse.returnShops();
        visitedStore = new boolean[shops.size()];
        
        shopsCopy = new ArrayList<CoffeeShop>(); //copy of shops
        
        for(int i = 0; i < visitedStore.length; i++){
            visitedStore[i] = false;
        }
        
        x = homeWarehouse.getX();
        y = homeWarehouse.getY();
    }

    /**
     * This method returns the capacity so it can be used in another class
     * 
     * @return  int, current capcity of the truck
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method subtracts the total capacity by the amount designated in the paramter
     * 
     * @param  amount   amount to remove from the capacity
     */
    public void subtractCapacity(int amount) {
        capacity = capacity - amount;
    }

    /**
     * This method plans the route of the truck and returns the distance it must travel
     * 
     * @return  int, distance the truck travelled
     */
    public int planRoute() {         
        boolean noPrint = false;      
        
        //create a copy of the shops in another arraylist
        for (int i = 0; i < shops.size(); i++) {
            int tempDist = calcDistance(x,y, shops.get(i).getX(), shops.get(i).getY());
            if(tempDist <= radius){
                shopsCopy.add(shops.get(i));
            }
            
        }
        int initialSize = shopsCopy.size();

        for (int i = 0; i < initialSize; i++) { //move through all shops and ensures every possible shop can be chosen 
            CoffeeShop currentShop = findClosest(); //finds the cloest shop

            if (capacity > 0) { //if capacity of truck is greater than 0
                ArrayList<Cargo> cargo = currentShop.getCargo(); //get list of cargo

                boolean visited = false; //if store was visited

                for (int j = 0; j < cargo.size(); j++) { //go through cargo
                    if (!(cargo.get(j).getIsDone()) && cargo.get(j).getWeight() <= capacity) { //if it can take cargo
                        if (!visited) { //if the shop has not been visited yet
                            System.out.println("        Visited shop " + currentShop.getID() + " at (" + currentShop.getX() + "," + currentShop.getY() + "). Delivered cargo: ");
                        }
                        System.out.println("          " + cargo.get(j).getWeight() + "lbs ");
                        subtractCapacity(cargo.get(j).getWeight()); //subtract weight from truck
                        homeWarehouse.removeCargo(j, getSpotInArray(currentShop));
                        visited = true; //it was visited
                    }
                }

                int tempDistance1 = 0;
                if (visited) { //if the store was visited
                    tempDistance1 = calcDistance(x, y, currentShop.getX(), currentShop.getY()); //add to the distance traveled
                    distance+=tempDistance1;

                    //update position of truck
                    x = currentShop.getX();
                    y = currentShop.getY();
                }

                boolean finishedCargo = true; //cargo was finsihed
                for (int j = 0; j < cargo.size(); j++) {
                    if (!cargo.get(j).getIsDone()) {
                        finishedCargo = false;
                    }
                }

                if (finishedCargo && tempDistance1 != 0) { //if cargo was finished and it traveled
                    //remove store from warehouse list with method
                    System.out.println("        Finished cargo for shop " + currentShop.getID() + " and traveled a distance of " + tempDistance1 + ".");
                    homeWarehouse.removeStore(getSpotInArray(currentShop));
                } else {
                    noPrint = true;
                }
            }
        }

        //get distance back to warehous
        int tempDistance2 = calcDistance(x, y, homeWarehouse.getX(), homeWarehouse.getY());
        distance+=tempDistance2;

        if (tempDistance2 > 0) {
            System.out.println("        Returned back to home warehouse at (" + homeWarehouse.getX() + "," + homeWarehouse.getY() + ") for a distance of " + tempDistance2 + 
            " and with a leftover weight of " + capacity +".");
        } else {
            System.out.println("        (Truck never actually left warehouse and traveled.)");
        }

        return distance;
    }
    
    /**
     * This method finds and returns the closest CoffeeShop to the truck
     * 
     * @return  CoffeeShop, closest coffeeshop to the truck
     */
    private CoffeeShop findClosest() {
        int shortestDistance = Integer.MAX_VALUE;
        final int PLACEHOLDER = 0;

        CoffeeShop optimalShop = new CoffeeShop(PLACEHOLDER, PLACEHOLDER, PLACEHOLDER, PLACEHOLDER, null); //creae temp shop
                
        for (int i = 0; i < shopsCopy.size(); i++) { //go through all shops
            int tempDistance = calcDistance(shopsCopy.get(i).getX(), shopsCopy.get(i).getY(), x, y);
            
            if (tempDistance < shortestDistance) { //if length of this shop is less than the saved temp value
                optimalShop = shopsCopy.get(i); //new optimal shop found
                shortestDistance = tempDistance;
            }
        }
        
        shopsCopy.remove(optimalShop); //remove shop from copied list so it doesn't get chosen again
        
        return optimalShop;
    }
    
    /**
     * This method gets the spot of a CoffeeShop in the master array in the Vertex class
     * 
     * @param  shop   shop to find the index of
     * @return  int, index of the shop
     */
    private int getSpotInArray(CoffeeShop shop) {
        for (int i = 0; i < shops.size(); i++) { //go through all shops
            if (shops.get(i).getID() == shop.getID()) { //look for coffeeshop
                return i;
            }
        }
        
        return -1; //will never get to this point
    }
    
    /**
     * Calculates and returns the Manhattan distance between two points
     * 
     * @param  x1   first x value
     * @param  y1   first y value
     * @param  x2   second x value
     * @param  y2   second y value
     * @return  int, distance between the points
     */
    private int calcDistance(int x1, int y1, int x2, int y2){
        return (Math.abs(x1 - x2) + Math.abs(y1-y2));
    }
}