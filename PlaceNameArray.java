/**
 *  A fixed -size array for storing placnameEntry objects and provides linear search.
 * Mpho Hadebe 
 * HDBMPH001
 * 19/03/2026
  */


public class PlaceNameArray{

     
       
       private PlaceNameEntry[] records  ;
       private int size ;
       private int counter; //comparison counter

       public PlaceNameArray(int maxSize){
        records = new PlaceNameEntry[maxSize];
        size = 0;
        counter =0;
       }
        
        /**
         * @param entry thr PlaceNameEntry to insert 
         */
       public void insert(PlaceNameEntry entry){
        //check for duplicates
        for (int i=0 ; i <size ;i++){
            if (records[i].getPlaceName().compareTo(entry.getPlaceName())==0){
                return ; //duplicate found .no longer insert
            }
            
        }
        if(size <records.length){
                records[size] = entry;
                size++ ;          
        }
       }

       /**@param  place the place name to search for 
         * @return  the PlaceNameEntry if found , null otherwisw
         */
       public PlaceNameEntry LinearSearch(String place){
        counter =0; // reset counter
        for (int i=0; i<size ; i++){
             counter++;
            
            if (records[i].getPlaceName().compareTo(place)==0){

                return records[i];
            }
           
        }
        
        return null;

        //getter for the comparison counter
       
        

       }
       /**
         * @return  the comparison count fromthe last search operation 
         */
        public int getLastSearchComparisons(){
            return counter;
        }
        /**
         * @return  the size of the array 
         */
       public int getSize(){
        return size;
       }

}


AI Assistance Disclosure

For this assignment, I used ChatGPT as a learning partner and writing helper. Here’s how I used AI throughout my work:

Understanding the Assignment
When I first read the assignment questions, I wasn't always sure how they connected to what we learned in class. I asked ChatGPT to break down each question and explain the link between the theory (like time complexity and tree balance) and what I was supposed to demonstrate in my experiment. This helped me see the bigger picture—like why we compare array vs. BST, or why insertion order even matters.

Clarifying Concepts
I also used AI to double-check my understanding of certain topics. For example, I'd ask things like:

* "Which is more efficient for searching—array or BST—and why?"
* "What happens to BST performance when data is inserted in sorted order?"
* "How does an optimal BST compare to a regular one?"

ChatGPT would explain these in plain language, which helped me confirm (or correct) what I thought I knew.


What AI Did NOT Do

* It did not write any of my code
* It did not run my experiments or collect my results
* It did not make decisions about what to test or how to interpret the data

I reviewed everything AI helped with and made sure it still sounded like me and matched what I actually learned. This project is ultimately my own work—AI was just a tool to help me understand and communicate better.