// Name:          <Feiyang Qu>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    2

//This is to test class Stack_Feiyang_Qu. Input,creat and print out a simple list

import java.util.Scanner;

public class TestStack_Feiyang_Qu
{
   public static void main (String[] args)
   {
      Stack_Feiyang_Qu myList = new Stack_Feiyang_Qu(); //create a list object
   
      for (int i = 1; i <= 5; i++) //add 5 nodes to the list
      {
         //String.valueOf(i);
         myList.push(String.valueOf(i));
      } 
       
      //print out the list content
      System.out.println("Testing method push()");
      System.out.println("Adding value 66.");
      System.out.print("List content before adding 66 is:  ");
      myList.printList(); //add 5 number
      myList.push("66"); //6th is "66"
      System.out.print("List content after adding 66 is:  ");
      myList.printList();
      System.out.println(" ");       

      System.out.println("Testing method pop()");
      System.out.println("Removing the value.");
      System.out.print("List content before removing is:  ");
      myList.printList();
      System.out.print("List content after removing is:  ");
      myList.pop();// remove 66
      myList.printList();
      System.out.println(" ");

      System.out.println("Testing method top()");
      System.out.println("Picking the top number.");
      myList.top(); //after remove 66, the top number should be last number 5
      System.out.printf("The number is: %s ",myList.top());      
      System.out.println(" ");
      System.out.println(" ");

      System.out.println("Testing method size()");
      myList.size(); //linked list size
      System.out.printf("Size of list is: %d ",myList.size());      
      System.out.println(" ");
      System.out.println(" ");   
         
      System.out.println("Testing method isEmpty()");
      System.out.println("Cleaning.");
      myList.isEmpty();
      System.out.print("The value is:");
      System.out.print(myList.isEmpty());//to show it is empty
     
   } 
}
