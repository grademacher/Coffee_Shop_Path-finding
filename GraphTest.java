import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GraphTest.
 *
 * @author  Garrett Rademacher
 * @author Joseph Teddick
 * @version 5/7/2017
 */
public class GraphTest
{
    @Test
    public void testConstructor1(){
        Graph graph = new Graph(5,4);
        assertEquals(9,graph.buildings.length);
    }
    
    @Test
    public void testConstructor2(){
        Graph graph = new Graph(5,4);
        assertEquals(4,graph.warehouses.length);
    }
    
    @Test
    public void testAddCoffee1(){
        Graph graph = new Graph(1,0);
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        graph.addCoffee(1,1,1,cargo);
        graph.addCoffee(1,1,2,cargo);
        assertEquals(1,1);//this is useless, if there is an error in the addCoffee method it
                          //should throw an error when it reaches the second add statement
                          //the lack of error shows the catches are working
    }
    
    @Test
    public void testAddCoffee2(){
        Graph graph = new Graph(1,0);
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        graph.addCoffee(1,1,1,cargo);
        graph.addCoffee(1,1,1,cargo);
        assertEquals(1,1);//this is useless, if there is an error in the addCoffee method it
                          //should throw an error when it reaches the second add statement
    }
    
    @Test
    public void testAddCoffee3(){
        Graph graph = new Graph(1,0);
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        graph.addCoffee(1,1,1,cargo);
        graph.addCoffee(1,2,1,cargo);
        assertEquals(1,1);//this is useless, if there is an error in the addCoffee method it
                          //should throw an error when it reaches the second add statement
    }
    
    @Test
    public void testAddCoffee4(){
        Graph graph = new Graph(2,0);
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        graph.addCoffee(1,1,1,cargo);
        graph.addCoffee(1,2,2,cargo);
        assertEquals(2, graph.buildings[1].getY());
    }
    
    @Test
    public void testAddWarehouse1(){
        Graph graph = new Graph(0,0);
        graph.addWarehouse(1,1,1,2,500);
        assertEquals(1,1);
    }
    
    @Test
    public void testAddWarehouse2(){
        Graph graph = new Graph(0,0);
        graph.addWarehouse(1,1,1,2,500);
        graph.addWarehouse(1,1,1,2,500);
        assertEquals(1,1);
    }
}