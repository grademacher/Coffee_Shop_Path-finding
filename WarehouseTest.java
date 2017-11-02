import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class WarehouseTest.
 *
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class WarehouseTest
{   
    /** Tests to make sure the number of shops added is correct (few shops) */
    @Test
    public void testGetShops1() {
        Graph test = new Graph(3, 1);
        ArrayList<Cargo> temp = new ArrayList<Cargo>();
        
        test.addCoffee(4, 2, 1, temp);
        test.addCoffee(1, 10, 2, temp);
        test.addCoffee(1, 3, 3, temp);
        test.addWarehouse(1, 1, 1, 5, 500);
        
        test.warehouses[0].getShops();
        
        assertEquals(3, test.warehouses[0].returnShops().size());
    }

    /** Tests to make sure the number of shops added is correct (many shops) */
    @Test
    public void testGetShops2() {
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
}