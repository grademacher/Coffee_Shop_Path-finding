import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CoffeeShopTest.
 *
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class CoffeeShopTest
{
    @Test
    public void testConstructorCargo1(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        Cargo c1 = new Cargo(10);
        Cargo c2 = new Cargo(15);
        Cargo c3 = new Cargo(20);
        cargo.add(c1);
        cargo.add(c2);
        cargo.add(c3);
        CoffeeShop shop = new CoffeeShop(1,1,1,0,cargo);
        ArrayList<Cargo> testCargo = shop.getCargo();
        
        assertEquals(10, testCargo.get(0).getWeight());
    }
    
    @Test
    public void testConstructorCargo2(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        Cargo c1 = new Cargo(10);
        Cargo c2 = new Cargo(15);
        Cargo c3 = new Cargo(20);
        cargo.add(c1);
        cargo.add(c2);
        cargo.add(c3);
        CoffeeShop shop = new CoffeeShop(1,1,1,0,cargo);
        ArrayList<Cargo> testCargo = shop.getCargo();
        
        assertEquals(15, testCargo.get(1).getWeight());
    }
    
    @Test
    public void testConstructorCargo3(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        Cargo c1 = new Cargo(10);
        Cargo c2 = new Cargo(15);
        Cargo c3 = new Cargo(20);
        cargo.add(c1);
        cargo.add(c2);
        cargo.add(c3);
        CoffeeShop shop = new CoffeeShop(1,1,1,0,cargo);
        ArrayList<Cargo> testCargo = shop.getCargo();
        
        assertEquals(20, testCargo.get(2).getWeight());
    }
    
    @Test
    public void testRemoveCargo(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        Cargo c1 = new Cargo(10);
        Cargo c2 = new Cargo(15);
        Cargo c3 = new Cargo(20);
        cargo.add(c1);
        cargo.add(c2);
        cargo.add(c3);
        CoffeeShop shop = new CoffeeShop(1,1,1,0,cargo);
        shop.removeCargo(c1);
        ArrayList<Cargo> testCargo = shop.getCargo();
        
        assertEquals(2, testCargo.size());
    }
    
    @Test
    public void testSetIsDone1(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        Cargo c1 = new Cargo(10);
        Cargo c2 = new Cargo(15);
        Cargo c3 = new Cargo(20);
        cargo.add(c1);
        cargo.add(c2);
        cargo.add(c3);
        CoffeeShop shop = new CoffeeShop(1,1,1,0,cargo);
        shop.removeCargo(c1);
        
        assertEquals(false, shop.getIsDone());
    }
    
    @Test
    public void testSetIsDone2(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        Cargo c1 = new Cargo(10);
        Cargo c2 = new Cargo(15);
        Cargo c3 = new Cargo(20);
        cargo.add(c1);
        cargo.add(c2);
        cargo.add(c3);
        CoffeeShop shop = new CoffeeShop(1,1,1,0,cargo);
        shop.setIsDone(true);
        
        assertEquals(true, shop.getIsDone());
    }
}