import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VertexTest.
 *
 * @author Garrett Rademacher
 * @author Joseph Teddick
 * @version 5/7/2017
 */
public class VertexTest
{
    @Test
    public void testX(){
        Vertex v = new Vertex(10,11,1,0);
        assertEquals(10, v.getX());
    }
    
    @Test
    public void testY(){
        Vertex v = new Vertex(10,11,1,0);
        assertEquals(11, v.getY());
    }
    
    /** Tests to make sure the number of edges added in is correct (few shops) (shops arraylist is collected from the edges array) */
    @Test
    public void testAddEdge1() {
        Graph test = new Graph(3, 1);
        ArrayList<Cargo> temp = new ArrayList<Cargo>();
        
        test.addCoffee(4, 2, 1, temp);
        test.addCoffee(1, 10, 2, temp);
        test.addCoffee(1, 3, 3, temp);
        test.addWarehouse(5, 5, 1, 5, 500);
        
        test.warehouses[0].getShops();
        
        assertEquals(3, test.warehouses[0].returnShops().size());
    }

    /** Tests to make sure the number of edges added in is correct (many shops) (shops arraylist is collected from the edges array) */
    @Test
    public void testAddEdge2() {
        Graph test = new Graph(6, 3);
        ArrayList<Cargo> temp = new ArrayList<Cargo>();
        
        test.addCoffee(4, 2, 1, temp);
        test.addCoffee(1, 10, 2, temp);
        test.addCoffee(1, 3, 3, temp);
        test.addCoffee(10, 2, 4, temp);
        test.addCoffee(19, 10, 5, temp);
        test.addCoffee(36, 3, 6, temp);
        test.addWarehouse(1, 1, 1, 5, 500);
        test.addWarehouse(1, 5, 2, 4, 500);
        test.addWarehouse(30, 4, 3, 2, 500);
        
        test.warehouses[0].getShops();
        
        assertEquals(6, test.warehouses[0].returnShops().size());
    }
    
    @Test
    public void testGetID(){
        Vertex v = new Vertex(1,1,10,0);
        assertEquals(10, v.getID());
    }
}