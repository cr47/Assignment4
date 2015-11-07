import java.util.*;
import java.io.*;


public class TestBinarySearchTree {

  public static void main(String[] args) {

      Integer[] num = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
      // Create an empty BinaryTree
      BinarySearchTree<Integer> tree = new BinarySearchTree<>(num);
     
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter an element to search: ");
      Integer key = input.nextInt();
      
       //complete the code as suggested in the Lab document.
      
      System.out.print("\nEnter an element to delete: "+tree.delete(key) );
  
              
     System.out.print("\n Insert a element: "+tree.insert(55));
   
      
      System.out.println("\n  Inorder:");
      tree.inorder();
      
      System.out.println("\n  Postorder:");
      tree.postorder();
      
      System.out.println("\n  Preorder:");
      tree.preorder();
      
      System.out.println("\n The tree path: "+ tree.path(87));
      
      System.out.println ("Enter the element to find the left subtree of: ");
      key = input.nextInt();
      System.out.print("\n List the left sub tree: ");
      tree.leftSubTree(67);
      System.out.println("");
      
      System.out.println ("Enter the element to find the right subtree of: ");
      key = input.nextInt();
      System.out.println("\n List the right sub tree:" );
      tree.rightSubTree(81);
      System.out.println("");
      
      
      System.out.println("\n Print the number of leaves: " + tree.getNumberOfLeaves());
      
    //  System.out.print ("Enter the element to find the predecessor: ");
    //  key = input.nextInt();
      System.out.println("\n Is the in order predecessor working: "+tree.inorderPredecessor(key));
    
      
  }
}
