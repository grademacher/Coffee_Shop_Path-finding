/**
 * This class is responsible for creating the link from one vertex to another. 
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class Edge implements Comparable<Edge>
{
    // instance variables
    private Vertex start;
    private Vertex end;
    private int weight;
    
    /**
     * Constructor for objects of class Graph
     */
    public Edge(Vertex start, Vertex end, int w){
        this.start = start;
        this.end = end;
        weight = w;
    }
    
    /**
     * Gets the end node of the edge (where the edge is pointing to) so it can be used in another class
     * 
     * @return  endpoint of the edge
     */
    public Vertex getEnd() {
        return end;
    }
    
    /**
     * Gets the weight of the edge so it can be used in another class
     * 
     * @return  int, weight of the edge
     */
    public int getWeight() {
        return weight;
    }
    
    
    /**
     * Compares the current edge to another edge to see which has a smaller weight
     * 
     * @param   Edge    the edge that is being compared
     * @return  int, weight of the edge
     */
    public int compareTo(Edge a) {
        if (this.getWeight() < a.getWeight()) {
            return -1;
        } else if (this.getWeight() > a.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}