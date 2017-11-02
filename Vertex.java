import java.util.*;

/**
 * This class is responsible for creating a Vertex that has the capabilities of adding edges and returning its location and ID.
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/4/2017
 */
public class Vertex
{
    // instance variables
    protected int x, y;
    protected int ID;
    protected Edge[] e;
    protected int edges = 0;
    
    /**
     * Constructor for objects of class Vertex
     * 
     */
    public Vertex(int x, int y, int ID, int edges){
        e = new Edge[edges];
        this.x = x;
        this.y = y;
        this.ID = ID;
    }
    
    /**
     * Add edges to a vertex
     * 
     * @param  start   vertex the edge starts at
     * @param  end   vertex the edge ends at
     * @param  weight   distance from start to end
     */
    public void addEdge(Vertex start, Vertex end, int weight) {
        Edge newEdge = new Edge(start, end, weight); //create the new edge
        
        ArrayList<Edge> temp = new ArrayList<Edge>(); //create temporary arraylist
        
        for (int i = 0; i < e.length; i++) { //go throught list of edges
            if (e[i] != null) {
                temp.add(e[i]); //add in non null ones
            }
        }
        
        temp.add(newEdge); //add in new edge
        
        Collections.sort(temp); //sort list
        
        for (int i = 0; i < temp.size(); i++) {
            e[i] = temp.get(i); //update edge array
        }
    }
    
    /**
     * get x location
     * 
     * @return      x coord of the vertex
     */
    public int getX(){
        return x;
    }
    
    /**
     * get y location
     * 
     * @return      y coord of the vertex
     */
    public int getY(){
        return y;
    }
        
    /**
     * get vertex ID
     * 
     * @return      ID
     */
    public int getID(){
        return ID;
    }
}