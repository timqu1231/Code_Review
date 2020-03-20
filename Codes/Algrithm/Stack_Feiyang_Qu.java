// Name:          <Feiyang>   
// Class:         CS 5040      
// Term:          Summer 2018 
// Instructor:    Dr. Haddad
// Assignment:    2

// This class defines linked list by stack ADT.

public class Stack_Feiyang_Qu
{
   private Node head, tail;
   private int size;
  
   //constructor method to create a list object with head, tail, and size. 
   public Stack_Feiyang_Qu()
   {
      head = null;  // list head pointer
      tail = null;  // list tail pointer
      size = 0;     // list size
   }
  
   //method to push(e)
   public void push(String data) 
   {
       if (tail == null) 
         head = tail = new Node(data); //empty list
      else 
      {
         tail.next = new Node(data); //link new node as last node
         tail = tail.next; //make tail pointer points to new last node
      }
      size++; //increase list size by one  
   }
      
   //method to pop()
   public boolean pop() //purpose for checkParentheses
   {
      if (size == 0)
         {
         return false; //checkParentheses-expression:1+1)
         }
     else if (size == 1)
         {
         head = tail = null;
         size = 0;
         return true;
         } 
     else
         {
         Node current = head;
         for (int i = 0; i < size - 2; i++)
             {
             current = current.next;
             }
         Node temp = tail;
         tail = current;
         tail.next = null;
         size --;
         return true;
         }  
   }
      
   //method to top()
   public String top()
   {
      return tail.data;
   }
   
   //method to size()
   public int size()
   {
      return size;
   }
   
   //method to isEmpty()
   public boolean isEmpty()
   {
      return (size == 0);
   }
   
   //method to print out the list
   public void printList() 
   {
      if (head == null)  // if an empty list
         System.out.println("List is empty...");
      else               // if non-empty list
      {
         Node temp;
         temp = head;
         while (temp != null)
         {
            System.out.print(temp.data + "   ");
            temp = temp.next;
         }
         System.out.println();
      }
   }
  
   //class to create nodes of the list as objects
   private class Node
   {
      private String data;  //data field
      private Node next; //link field
       
      public Node(String item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}
