import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EdgeTest.
 *
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class EdgeTest
{
    @Test
    public void testGetEnd(){
        Vertex start = new Vertex(1,1,1,1);
        Vertex end = new Vertex(2,2,2,0);
        Edge e = new Edge(start, end, 10);
        assertEquals(2, e.getEnd().getID());
    }
    
    @Test
    public void testGetWeight(){
        Vertex start = new Vertex(1,1,1,1);
        Vertex end = new Vertex(2,2,2,0);
        Edge e = new Edge(start,end,2);
        assertEquals(2, e.getWeight());
        
    }
}
