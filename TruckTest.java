import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TruckTest.
 *
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class TruckTest
{
    /** Tests that the Truck returns the proper capacity */
    @Test
    public void testGetCapacity() {
        Truck test = new Truck(10, new Warehouse(5, 5, 2, 200, 4, 50, 10),10);
        
        assertEquals(10, test.getCapacity());
    }
    
    /** Test that the Truck subtracts the capacity properly */
    @Test
    public void testSubtractCapacity() {
        Truck test = new Truck(10, new Warehouse(5, 5, 2, 200, 4, 50,10),10);
        
        test.subtractCapacity(7);
        
        assertEquals(3, test.getCapacity());
    }
}
