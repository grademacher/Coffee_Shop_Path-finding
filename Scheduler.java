import java.io.*;
import java.util.*;

/**
 * This class is responsible for in taking notepad files and then simulating the events in Coffee Town and printing out the optimal distance.
 * 
 * @author Joseph Teddick
 * @author Garrett Rademacher
 * @version 5/7/2017
 */
public class Scheduler
{
    private int coffeeshopNum, warehouseNum;
    private Graph graph;    
    
    /** 
     * Main method
     * 
     */
    public static void main(String[] args) {
        String shopsFileName = "";
        String warehouseFileName = "";
        File shopsFile;
        File warehouseFile;
    
        Scheduler test = new Scheduler();
        shopsFileName = args[0];
        shopsFile = new File(shopsFileName);
        warehouseFileName = args[1];
        warehouseFile = new File(warehouseFileName);
        test.addData(shopsFile, warehouseFile);
        test.runTest();
    }
    
    /**
     * Adds in all the data from files.
     * 
     * @param   shopF   file that contains shop information
     */
    private void addData(File shopF, File warehouseF) {
        String firstKey = ""; //first key that is added in to the graph
        
        //create scanners
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        
        try {
            scan1 = new Scanner(shopF); //create a scanner for the notepad file
            scan2 = new Scanner(warehouseF); //create a scanner for the notepad file
        } catch (Exception e) {
            System.out.println(e);
        }
            
        coffeeshopNum = Integer.parseInt(scan1.nextLine()); //number of coffee shops
        warehouseNum = Integer.parseInt(scan2.nextLine()); //number of warehouses
        
        graph = new Graph(coffeeshopNum, warehouseNum); //creates a new graph
        
        
        while (scan1.hasNextLine()) { //goes through the coffeeshop file and adds in all of the coffee shops
            String sentence = scan1.nextLine();
            
            Scanner scan1Next = new Scanner(sentence);
            
            String temp = "";
            int x;
            int y;
            int ID;
            ArrayList<Cargo> cargo = new ArrayList<Cargo>();
            
            ID = Integer.parseInt(scan1Next.next()); //id of shop
            
            temp = scan1Next.next();
            x = Integer.parseInt(temp.substring(1, temp.length() - 1)); //x coordinate
            
            temp = scan1Next.next();
            y = Integer.parseInt(temp.substring(0, temp.length() - 2)); //y coordinate
            
            while(scan1Next.hasNext()) {
                String value = scan1Next.next();
                int pos = value.indexOf(","); //take out commas
                
                if (pos >=0) {
                    value = value.substring(0, pos);
                }
                
                cargo.add(new Cargo(Integer.parseInt(value))); //add in cargo
            }
            
            graph.addCoffee(x, y, ID, cargo);
        }
        
        while (scan2.hasNextLine()) { //goes through the warehouse file and adds in all of the warehouses
            String sentence = scan2.nextLine();
            
            Scanner scan2Next = new Scanner(sentence);
            
            String temp = "";
            int x;
            int y;
            int ID;
            int trucks;
            
            ID = Integer.parseInt(scan2Next.next()); //id of warehouse
            
            temp = scan2Next.next();
            x = Integer.parseInt(temp.substring(1, temp.length() - 1)); //x coordinate
            
            temp = scan2Next.next();
            y = Integer.parseInt(temp.substring(0, temp.length() - 2)); //y coordinate
            
            trucks = Integer.parseInt(scan2Next.next()); //number of trucks
            
            graph.addWarehouse(x, y, ID, trucks, 500);
        }            
    }
    
    /** 
     * This method runs the simulation and calculates the total distance
     * 
     */
    private void runTest() {
        int distance = graph.calcTotalDistance();
        
        System.out.println("The total distance traveled was " + distance + "!");
    }
}