import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CargoTest.
 *
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class CargoTest
{
    /** Tests to make sure the Cargo returns the correct weight */
    @Test
    public void testGetWeight() {
        Cargo test = new Cargo(5);
        
        assertEquals(5, test.getWeight());
    }
    
    @Test
    public void testIsDone1() {
        Cargo test = new Cargo(5);
        
        assertEquals(false, test.getIsDone());
    }
    
    @Test
    public void testIsDone2() {
        Cargo test = new Cargo(5);
        test.setIsDone(true);
        
        assertEquals(true, test.getIsDone());
    }
}
