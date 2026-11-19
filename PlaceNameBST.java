/** 
 * A Binary search tree Implementation for storing managing PlaceNameENtry objects
 * 
 * Mpho Hadebe
 * HDBMPH001
 * 119/03/2026
 * 
 */

public class PlaceNameBST{
    
    
    
     private BSTNode root ;
     private int lastSearch; //counting comparions 

    public PlaceNameBST(){
        root =null;
        lastSearch = 0;
    }
     public void insert(PlaceNameEntry p){
        if (root ==null){
             root = new BSTNode(p, null, null);
        }   
        else {
            insert(root, p);
        }
     }
    /**
     * @param root of the current node 
     * @param p th PlaceNameEntry to insert
     */
         private void  insert(BSTNode root , PlaceNameEntry p){
        if (p.getPlaceName().compareTo(root.getData().getPlaceName())<0){
               if(root.getLeft()==null){
                root.setLeft(new BSTNode(p ,null ,null)) ;
               }
               else{insert(root.getLeft(),p);
               }
        }
        else if (p.getPlaceName().compareTo(root.getData().getPlaceName())>0){
              if(root.getRight()==null){
                root.setRight( new BSTNode(p ,null ,null));
               }
               else{insert(root.getRight(),p);}
        }
        else {return ;}
           
        }

        public  PlaceNameEntry find(String p){
            lastSearch =0;
            if (root==null){
                return null;

            }
            else{
                return find(root, p);

            }
        }


        private  PlaceNameEntry find(BSTNode root, String place){ // method to search for a place name on the BST

            if (root == null ){
                 return null;
            }
            lastSearch++;
            if (place.compareTo(root.getData().getPlaceName())==0) return root.getData();
            else if (place.compareTo(root.getData().getPlaceName())<0){
               return  find(root.getLeft(), place);
            }
            else{
                return  find(root.getRight(), place);

            }
        }

        public boolean delete(String place){ // to also check if the place to be deleted exist in the records
            if (find(place)== null){
                return false;
            }
            root = delete(root , place);   // the method must return new root after deletion
            //the recursive BST deletion needs updated subtree roots
            return true; // meaning the place to be delete has been successfully deleted 

              
        }
        private BSTNode delete(BSTNode node, String place){
            if (node == null ) return null;
            if (place.compareTo(node.getData().getPlaceName())<0 ){
                node.setLeft(delete(node.getLeft(), place));
            }
            else if (place.compareTo(node.getData().getPlaceName())>0){
                   node.setRight(delete(node.getRight(), place)); // 
            }
            else if (node.getLeft() != null && node.getRight() != null ){ // case 3 two children
                    node.setData(findMin(node.getRight()).getData());
                    node.setRight(removeMin(node.getRight()));
             }
             else{ // case 1 or 2
                if (node.getLeft() != null) node = node.getLeft();
                else node = node.getRight();
             }
             return node ;
            }
        

        public BSTNode findMin(BSTNode node){ // helper method
            if(node != null){
                while(node.getLeft()!= null){
                    node = node.getLeft();
                }
            }
            return node;
        }
        public BSTNode removeMin(BSTNode node){
            if (node == null){
                return null;
            }
            else if (node.getLeft()!= null){
                node.setLeft(removeMin(node.getLeft()));
                return node;
            }
            else {
                return node.getRight();
            }
        }


        public int getLastSearch(){// method to return the nu,ber of searches made up to until we find the placename being searhced for
            return lastSearch;
        }

        public int getSize(){
            return size(root);

        }
        private int size(BSTNode node){// method to return the number of nodes from the root
            if (node ==null )return 0;
            return 1+ size(node.getLeft())+ size(node.getRight());
        }
     
 
}