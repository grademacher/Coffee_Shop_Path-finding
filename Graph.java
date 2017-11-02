import java.util.*;

/**
 * The graph class is responsible for adding in all of the Coffee Shops and Warehouses and calculating the total optimal distance.
 * 
 * @author Garrett Rademacher
 * @author Joseph Teddick
 * @version 5/7/2017
 */
public class Graph
{
    // instance variables
    private int size; //size of the graph
    public Vertex[] buildings; //array of all buildings (vertices)
    public Warehouse[] warehouses; //array of the warehouses
    private int coffeeshopNum = 0; //# of coffeeshops
    private int warehouseNum = 0;// # of warehouses
    private int finalDistance = 0;
    
    /**
     * Constructor for objects of class Graph
     */
    public Graph(int coffeeshopNum, int warehouseNum) {
        buildings = new Vertex[coffeeshopNum+warehouseNum];
        warehouses = new Warehouse[warehouseNum];
        this.coffeeshopNum = coffeeshopNum;
        this.warehouseNum = warehouseNum;
    }
    
    /**
     * Add coffee shops to the graph
     * 
     * @param  x   x coord of the shop
     * @param  y   y coord of the shop
     * @param  ID   ID of the coffee shop
     * @param  cargo   list of cargo the shop wants
     */
    public void addCoffee(int x, int y, int ID, ArrayList<Cargo> cargo){
        if(ID > coffeeshopNum){return;} //check to make sure not too many shops are added
        for(int i  = 0; i < ID; i++){
            if(buildings[i] != null && x == buildings[i].getX() && y == buildings[i].getY()){
                return;
            }
            if(buildings[i] != null && ID == buildings[i].getID()){
                return;
            }
        }
        CoffeeShop c = new CoffeeShop(x,y,ID,coffeeshopNum,cargo);
        buildings[ID-1] = c;
        size++;
    }
    
    /**
     * Add warehouses to the graph
     * 
     * @param  x   x coord of the shop
     * @param  y   y coord of the shop
     * @param  ID   ID of the warehouse
     * @param  trucks   number of trucks the warehouse has
     */
    public void addWarehouse(int x, int y, int ID, int trucks, int capacity){
        if(ID > warehouseNum){return;} //check to make sure not too many warehouses are added
        
        for(int i  = 0; i < coffeeshopNum + ID - 2; i++){
            if(buildings[i] != null && x == buildings[i].getX() && y == buildings[i].getY()){
                return;
            }
        }
        
        int radius = 15;
        if(ID == warehouseNum){
            radius = 110;
        }
        
        //create and add a warehouse
        Warehouse w = new Warehouse(x, y, ID, coffeeshopNum, trucks, capacity, radius);
        buildings[coffeeshopNum + warehouseNum - 1] = w;
        warehouses[ID-1] = w;
        size++;
        //create edges to all of the coffeeshops
        for(int i  = 0; i < coffeeshopNum; i++){
            w.addEdge(w,buildings[i], getDistance(w,buildings[i]));
        }
    }
    
    /**
     * Returns the manhattan distance of two vertices
     * 
     * @param   start   the first vertice
     * @param   end     the end vertice 
     * @return  returns the total distance travelled by all trucks
     */
    private int getDistance(Vertex start, Vertex end){
        return (Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY()));
    }
    
    /**
     * Runs the main distance calculations
     * 
     * @return  returns the total distance travelled by all trucks
     */
    public int calcTotalDistance(){
        for(int i = 0; i < warehouses.length; i++){
            if (warehouses[i] != null) {
                warehouses[i].getShops();
                System.out.println("Warehouse " + (i + 1) + ":");
                finalDistance += warehouses[i].dispatchTrucks();
            }
        }
        return finalDistance;
    }
}