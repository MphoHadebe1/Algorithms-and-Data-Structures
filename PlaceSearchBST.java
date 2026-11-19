import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** 
 * AN INTERACTIVE COMMAND -LINE PROGRAM FROM MANAGING PLACE NAME DATA USING A BST
 * ALL OPERATIONS ARE PERFORMED ON A BST STRUCTURE FOR EFFICIENT SEARCHING
 * 
 * MPHO HADEBE
 * HDBMPH001
 * 19/03/2026
 */

public class PlaceSearchBST{
    public static void main(String... args){
        Scanner in = new Scanner(System.in);
            

            int option = 0;
            int count =0;
              PlaceNameBST myBST =null;
            
        while(option!=4){
             System.out.println("======Interactive file======");
            System.out.println("1. load dataset");
            System.out.println("2 Search for a place name");
            System.out.println("3. Delete a place name");
            System.out.println("4 Quit");
            

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
                myBST = new PlaceNameBST();
                while ((line = read.readLine() )!= null && countingrecs<Number){
                      countingrecs++;
                      String[] observations = line.split(",");
                      int population = Integer.parseInt(observations[4].trim());
                     //  
                      PlaceNameEntry observation = new PlaceNameEntry(observations[1].trim(),observations[2].trim(),observations[3].trim(),population );

                    myBST.insert(observation);
                      

                }

                read.close();
                
                }
                catch(IOException e){
                    System.out.println("Error reading the file");
                }
             }
             else if(option==2){
               if (myBST == null){
                    System.out.println("Please load dataset first");

               }else{
                System.out.println("Enter the place name:");
                String searchName = in.nextLine().trim();
               
                System.out.println("Searching...");
                PlaceNameEntry place = myBST.find(searchName);
                
                if (place == null){
                      System.out.println("not found");
                      System.out.println();
                      
                    
                }
                else{  System.out.println(place.toString());
                
                System.out.print("The Comparisons made: ");
                System.out.println(myBST.getLastSearch());
                
                
                }
               }
              

             }
             else if (option == 3){
               if (myBST == null){
                    System.out.println("Please load dataset first");
               } else{
                    System.out.println("Enter the name place to delete");
                    String toDelete = in.nextLine().trim();

                   boolean delete=  myBST.delete(toDelete);
                   if (delete){
                    System.out.println(toDelete+ " has been successfully deleted");
                   }
                   else{
                    System.out.println("Place not found");
                   }
                     
                   System.out.println();
               }
             }
             else if(option ==4){
                System.out.println("Goodbye!");

             }
             else{
                System.out.println("Invalid option");
             }
        }
        


          in.close(); 

        }

     
    }
     
