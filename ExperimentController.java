import java.io.*;
import java.util.*;

/**
 * This class is responsible for reading from a .txt file, adding in all the nodes, edges, and then printing out the closest neighbor in a breadth first order
 * 
 * @author Garrett Rademacher
 */
public class ExperimentController
{
    private int coffeeshopNum, warehouseNum;
    private Graph graph;
    private String[] sFileName = {"shops10.txt","shops11.txt","shops12.txt","shops.txt","shops.txt","shops.txt"};
    private String[] wFileName = {"warehouses10.txt","warehouses11.txt","warehouses12.txt","warehouses13.txt","warehouses1.txt","warehouses2.txt"};
    private int[] distances = new int[6];
    private File outputFile = new File("distances.csv"); //file where the output will be printed
    private PrintWriter pw = null; //print writer to print the output in the output file
    
    
    /** Main method */
    public static void main(String[] args) {
        ExperimentController test = new ExperimentController();
        test.run();
    }
    
    /** This method reads from the two notepad files and adds all of the data into the graph */
    private void run() {
        for(int i = 0; i < 6; i++){
            readFiles(sFileName[i], wFileName[i]);
            distances[i] = calcDistance();
        }
        
        try{
            if(!outputFile.exists()){//check to make sure the output file exists
                outputFile.createNewFile();
            }
            pw = new PrintWriter(outputFile); //link the output file to the print writer
        }catch(Exception e){
            System.out.println("Exception occured " + e);
        }
        
        for(int i = 0; i < 6; i++){
            pw.println(distances[i]);
        }
        pw.close();
    }
    
    private void readFiles(String shopFileName, String warehouseFileName){
        File shopF = new File(shopFileName);
        File warehouseF = new File(warehouseFileName);
        graph = null;
        String firstKey = ""; //first key that is added in to the graph
        
        //create scanners
        Scanner scan1 = null;
        Scanner scan2 = null;
        
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
    
    /** This method runs the simulation and calculates the total distance */
    private int calcDistance() {
        int distance = graph.calcTotalDistance();
        
        System.out.println("The total distance traveled was " + distance + "!");
        return distance;
    }
}