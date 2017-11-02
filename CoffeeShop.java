import java.util.*;

/**
 * This class is responsible for constructing a Coffee Shop, a sublcass of vertex, and storing an array of Cargo.
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class CoffeeShop extends Vertex
{
    private ArrayList<Cargo> cargo;
    private boolean isDone = false;
    
    /**
     * Constructor for objects of class CoffeeShop
     */
    public CoffeeShop(int x, int y, int ID, int edges, ArrayList<Cargo> cargo) {
        super(x, y, ID, edges);
        this.cargo = cargo;
    }
    
    /**
     * Gets the cargo list from the CoffeeShop
     * 
     * @return ArrayList of cargo
     */
    public ArrayList<Cargo> getCargo() {
        return cargo; 
    }
    
    /**
     * removes a cargo item from the CoffeeShop cargo list
     * 
     * @param  temp     cargo item to remove
     */
    public void removeCargo(Cargo temp){
        cargo.remove(temp);
    }
    
    /**
     * Set whever the CoffeeShop is complete
     * 
     * @param  value   boolean value to set
     */
    public void setIsDone(boolean value) {
        isDone = value;
    }
    
    /**
     * Getter for isDone value
     * 
     * @return  return whether the coffeeshop is done
     */
    public boolean getIsDone() {
        return isDone;
    }
}