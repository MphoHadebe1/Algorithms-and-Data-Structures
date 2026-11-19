/**
 * represent a node in a binary search Tree (BST) that stores PlaceNameEntry Objects
 * Mpho Hadebe
 * HDBMPH001
 * 19/03/2026
 */

public class BSTNode {
    private PlaceNameEntry data;
    private BSTNode left;
    private  BSTNode right;
    
    /** construct a new BSTNode with the specified data and child references
     * 
     * @param data the placeNameEntry to store
     * @param left referrence to the left node 
     * @param right reference to the right child 
     */
    public BSTNode(PlaceNameEntry data, BSTNode left , BSTNode right){
        this.data = data;
        this.left = left;
        this.right = right;

    }

    //Getter and setter for the data 
    public PlaceNameEntry getData(){
        return data;
    }
    public void setData(PlaceNameEntry data){
        this.data = data;
    }

    //getter and setter for left and right 
    public BSTNode getLeft(){
        return this.left;

    }
    public BSTNode getRight(){
        return this.right;

    }

    public void setRight(BSTNode right){
        this.right = right ;

    }
    
    public void setLeft(BSTNode left){
        this.left = left;
    }
    

}