/**
 * This class is responsible for holding the weight of a certain piece of cargo and returning it when necessary.
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class Cargo
{
    private int weight; //the weight of the cargo
    private boolean isDone = false;
    
    /**
     * Constructor for objects of class Graph
     */
    public Cargo(int weight) {
        this.weight = weight;
    }
    
    /**
     * This method returns the weight of the piece of cargo so it can be used in another class
     * 
     * @return  int, the weight of the cargo
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * returns if a cargo order has been fulfiled so it can be used in another class
     * 
     * @return  boolean, whether the cargo has been delivered
     */
    public boolean getIsDone() {
        return isDone;
    }
    
    /**
     * This method sets whether a cargo order has been fulfilled or not
     * 
     * @param  value boolean value
     */
    public void setIsDone(boolean value) {
        isDone = value;
    }
}