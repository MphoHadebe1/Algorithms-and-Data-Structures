


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * EXPERIMENTAL PERFORMANCE COMPARISON OF DIFFERENT DATA STRUCTURES FOR PLACE NAME SOTRAGE AND SEARCH
 * COMPARES ARRAY, BST(AS-IS), BST(SORTED), BST(OPTIMAL )
 * MPHO HADEBE
 * HDBMPH001
 * 
 */

public class PlaceExperiment{

    public static void main(String... args){
        int[] ten_values =  {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

        List<PlaceNameEntry> allRecords = new ArrayList<>();
        List<PlaceNameEntry> allRecords_2 = new ArrayList<>();
        List<String> allRecords_3 = new ArrayList<>();

        List<PlaceNameEntry> uniqueRecords = new ArrayList<>(); // to store unique entries
        List<PlaceNameEntry> uniqueRecords_2 = new ArrayList<>();
        // SETS TO TRACK DUPLICATE PLACE NAMES 
        Set<String> stored = new HashSet<>(); // set cannot store duplicate values
            Set<String> stored_2 = new HashSet<>();


        try{

        
        BufferedReader reader = new BufferedReader(new FileReader("SAPlaceNames.csv"));
      
        
        String line;
        line = reader.readLine();
        while ((line = reader.readLine())!= null){
            String[] observations = line.split(",");
                      int population = Integer.parseInt(observations[4].trim());
                     //  
                      PlaceNameEntry observation = new PlaceNameEntry(observations[1].trim(),observations[2].trim(),observations[3].trim(),population );
                      allRecords.add(observation);

        }
        reader.close();
        

        for (PlaceNameEntry entry : allRecords){
            if(!stored.contains(entry.getPlaceName())){
                stored.add(entry.getPlaceName());
                uniqueRecords.add(entry);
            }
        }
        Collections.sort(uniqueRecords, (a,b) -> a.getPlaceName().compareTo(b.getPlaceName()));
        
         
        for (PlaceNameEntry entry : allRecords){
            if(!stored_2.contains(entry.getPlaceName())){
                stored_2.add(entry.getPlaceName());
                uniqueRecords_2.add(entry);
            }
        }
         System.out.println("______________________________________________________________");
         System.out.println("N          Array     BST(as-is)    BST(sorted)   BST(optimal)|") ;
        


           try{

        BufferedReader reader_2 = new BufferedReader(new FileReader("SAPlaceNamesOptimal.txt"));
         String line_1;
         

        while((line_1 = reader_2.readLine())!= null){
            line_1 = line_1.trim();
          allRecords_2.add(new PlaceNameEntry(line_1,null,null,0));

          
        }
        reader_2.close();
         

        

        }catch(IOException e){
        }

        
        // dealing with SearchQueries.txt

        try{
             BufferedReader reader_3= new BufferedReader(new FileReader("SearchQueries.txt"));
              
            
            String line_2 ;
             while((line_2 = reader_3.readLine())!= null){
              line_2 = line_2.trim();
             allRecords_3.add(line_2);
             }
           reader_3.close();





          
        }catch(IOException e){

        }

        for (int N : ten_values){
            // create a new array with capacity N 
            PlaceNameArray unique_array = new PlaceNameArray(N);
                
            // Insert the first N records from the csv (as is order)
            for (int i = 0; i < N; i++){
                unique_array.insert(uniqueRecords_2.get(i));
            }
            // to check print the size of array 
            // System.out.println("Array for N = " + N +"has "+unique_array.getSize() );


            // as is (order for BST)
            PlaceNameBST bstAsIs = new PlaceNameBST();

            //insert the first N records from csv(as is order)
            for (int i=0 ; i<N ; i++){
                bstAsIs.insert(uniqueRecords_2.get(i));
            }
            // print confirmation
            // System.out.println("BST( as is order) for N = "+ N+ "loaded." + bstAsIs.getSize());

                //for sorted 
             PlaceNameBST bstSorted = new PlaceNameBST();
              for (int i=0 ; i<N ; i++){
                bstSorted.insert(uniqueRecords.get(i));
            }
            // System.out.println("BST( Sorted ) for N = "+ N+ "loaded." + bstSorted.getSize());

            //for optimal ordered
              PlaceNameBST bstOptimal = new PlaceNameBST();
           for (int i=0 ; i<N ; i++){
                bstOptimal.insert(allRecords_2.get(i));
           }  
            // System.out.println("BST( Optimal ) for N = "+ N+ "loaded." + bstOptimal.getSize());

            // time to search and print results

             int totalSearchArray= 0;
             int totalSearchBSTAsIs =0;
             int totalSearchBSTSorted =0;
             int totalSearchBSTOptimal =0;

             //run N queries * 50 
             for (String q : allRecords_3){
                unique_array.LinearSearch(q);
                totalSearchArray+=unique_array.getLastSearchComparisons();

                bstAsIs.find(q);
                totalSearchBSTAsIs += bstAsIs.getLastSearch();

                bstSorted.find(q);
                totalSearchBSTSorted += bstSorted.getLastSearch();

                bstOptimal.find(q);
                totalSearchBSTOptimal += bstOptimal.getLastSearch();

             }
             //compute averages
             double avergArray = (double) totalSearchArray / allRecords_3.size();
             double avergAsIs=  (double)  totalSearchBSTAsIs / allRecords_3.size();
             double avergSorted= (double) totalSearchBSTSorted / allRecords_3.size();
             double avergOptimal = (double) totalSearchBSTOptimal / allRecords_3.size();

             //print results
             System.out.printf("%-5d     %-7.2f      %-7.2f       %-7.2f       %-7.2f   |\n", N, avergArray, avergAsIs, avergSorted, avergOptimal);

        }


      //  System.out.println("Unique reocrds: "+ uniqueRecs.size());
        
        System.out.println("_____________________________________________________________|");
        }catch(IOException e){

        }

     

    }
}