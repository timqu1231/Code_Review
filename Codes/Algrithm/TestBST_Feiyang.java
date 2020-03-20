// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    4

public class TestBST_Feiyang{
     public static void main(String[] args) {
       // Create a BST
       BST_Feiyang<String> tree = new BST_Feiyang<>();
       tree.insert("George");
       tree.insert("Michael");
       tree.insert("Tom");
       tree.insert("Adam");
       tree.insert("Jones");
       tree.insert("Peter");
       tree.insert("Daniel");

       // Traverse tree
       System.out.print("Inorder (sorted): ");
       tree.inorder();
       System.out.print("\nPostorder: ");
       tree.postorder();
       System.out.print("\nPreorder: ");
       tree.preorder();
       System.out.print("\nThe number of nodes is " + tree.getSize());
   
       // Search for an element
       System.out.print("\nIs Peter in the tree? " +
       tree.search("Peter"));

       // Get a path from the root to Peter
       System.out.print("\nA path from the root to Peter is: ");
       java.util.ArrayList<BST_Feiyang.TreeNode<String>> path
         = tree.path("Peter");
       for (int i = 0; path != null && i < path.size(); i++)
         System.out.print(path.get(i).element + " ");

       Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
       BST_Feiyang<Integer> intTree = new BST_Feiyang<>(numbers);
       System.out.print("\nInorder (sorted): ");
       intTree.inorder();
    }
}
