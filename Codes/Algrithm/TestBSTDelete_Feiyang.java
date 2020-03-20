// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    4

public class TestBSTDelete_Feiyang{
   public static void main(String[] args) {
      BST_Feiyang<String> tree = new BST_Feiyang<>();
      tree.insert("George");
      tree.insert("Michael");
      tree.insert("Tom");
      tree.insert("Adam");
      tree.insert("Jones");
      tree.insert("Peter");
      tree.insert("Daniel");
      printTree(tree);
   
      System.out.println("\nAfter delete George:");
      tree.delete("George");
      printTree(tree);
     
      System.out.println("\nAfter delete Adam:");
      tree.delete("Adam");
      printTree(tree);
     
      System.out.println("\nAfter delete Michael:");
      tree.delete("Michael");
      printTree(tree);
   }
 
   public static void printTree(BST_Feiyang tree) {
   // Traverse tree
      System.out.print("Inorder (sorted): ");
      tree.inorder();
      System.out.print("\nPostorder: ");
      tree.postorder();
      System.out.print("\nPreorder: ");
      tree.preorder();
      System.out.print("\nThe number of nodes is " + tree.getSize());
      System.out.println();
   }
}

  