// Name:          <Feiyang Qu>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    1

//This is to test class LinkedList. Create and print out a simple list

import java.util.Scanner;

public class myTest_Qu
{
   public static void main (String[] args)
   {
      LinkedList_Qu myList = new LinkedList_Qu(); //create a list object
   
      for (int i=1; i <= 5; i++) //add 5 nodes to the list
      {
         myList.addLastNode(i);
      } 
      
      //print out the list content
      System.out.println("Testing method addFirstNode()");
      System.out.println("Adding value 66 as first node.");
      System.out.print("List content before adding 66 is:  ");
      myList.printList();
      myList.addFirstNode(66);
      System.out.print("List content after adding 66 is:  ");
      myList.printList();
      System.out.println(" ");       

      System.out.println("Testing method addAtIndex()");
      System.out.println("Adding value 3,88 as AtIndex node.");
      System.out.print("List content before adding 88 is:  ");
      myList.printList();
      System.out.print("List content after adding 88 is:  ");
      myList.addAtIndex(3,88);
      myList.printList();
      System.out.println(" ");
      
      System.out.println("Testing method removeFirstNode()");
      System.out.println("Removing first value.");
      System.out.print("List content before removing is:  ");
      myList.printList();
      System.out.print("List content after removing is:  ");
      myList.removeFirstNode();
      myList.printList();
      System.out.println(" ");

      System.out.println("Testing method removeLastNode()");
      System.out.println("Removing last value.");
      System.out.print("List content before removing is:  ");
      myList.printList();
      System.out.print("List content after removing is:  ");
      myList.removeLastNode();
      myList.printList();
      System.out.println(" ");

      System.out.println("Testing method removeAtIndex()");
      System.out.println("Removing at 4th Index value.");
      System.out.print("List content before removing is:  ");
      myList.printList();
      System.out.print("List content after removing is:  ");
      myList.removeAtIndex(3);
      myList.printList();
      System.out.println(" ");

      System.out.println("Testing method copyList()");
      System.out.println("Copying List.");
      System.out.print("List content before copying is:  ");
      myList.printList();
      System.out.print("List content after copying is:  ");
      LinkedList_Qu List2 = myList.copyList();
      List2.printList();
     
            
      //Now, write code to tast each completed method in class LinkedList
      //Add proper statement before the outputs of each method
      //Spaceout and organized your output 
   } 
}
    
