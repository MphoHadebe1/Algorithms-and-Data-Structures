import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** 
 * AN interactive command-line program for loading, searching place name data in an array
 * MPHO HADEBE
 * HDBMPH001
 * 19/03/2026
 */

public class PlaceSearchArray{
    public static void main(String... args){
        Scanner in = new Scanner(System.in);
            

            int option = 0;
            int count =0;
              PlaceNameArray list1 = null;
            
        while(option!=3){
             System.out.println("======Interactive file======");
            System.out.println("1. load dataset");
            System.out.println("2 Search for a place name");
            System.out.println("3. Quit ");

             System.out.println("Enter option:");
             option = in.nextInt();
             in.nextLine();

             if (option==1){
                System.out.println("Enter the name of the file: ");
                String filename = in.nextLine();

                System.out.println("Enter the number of records to load: ");
                int Number = in.nextInt();
                in.nextLine();

                try{

                BufferedReader read = new BufferedReader(new FileReader(filename));
                 String line;
                 read.readLine();


                 int countingrecs =0;
                 list1 = new PlaceNameArray(Number);
                while ((line = read.readLine() )!= null && countingrecs<Number){
                      countingrecs++;
                      String[] observations = line.split(",");
                      int population = Integer.parseInt(observations[4].trim());
                     //  
                      PlaceNameEntry observation = new PlaceNameEntry(observations[1].trim(),observations[2].trim(),observations[3].trim(),population );

                      list1.insert(observation);
                     

                }

                read.close();
                System.out.println("Data loaded");
                      System.out.println();
                
                }
                catch(IOException e){
                    System.out.println("Error reading the file");// THROWS ERROR IF THERES ERROR READING THE FILE 
                }
             }
             else if(option==2){
                System.out.println("Enter the place name:");
                String searchName = in.nextLine().trim();
               
                System.out.println("Searching...");
                PlaceNameEntry place = list1.LinearSearch(searchName);
                
                if (place == null){
                      System.out.println("not found");
                      System.out.println();
                      
                    
                }
                else{  System.out.println(place.toString());
                
                System.out.print("Number of comparions: ");
                System.out.println(list1.getLastSearchComparisons());}
              

             }
             
             else if(option ==3){
                System.out.println("Goodbye!");

             }
             else{
                System.out.println("Invalid option");
             }
        }
        


          in.close(); 

        }

     
    }
     
